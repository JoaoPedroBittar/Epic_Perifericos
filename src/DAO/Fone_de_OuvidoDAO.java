package DAO;

import Model.Fone_de_Ouvido;
import Model.Teclado;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fone_de_OuvidoDAO {

    public static ArrayList<Fone_de_Ouvido> MinhaLista = new ArrayList<Fone_de_Ouvido>();

    public Fone_de_OuvidoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_produtos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException ex) {
        }

        return maiorID;
    }

    public Connection getConexao() {

        Connection connection = null;  //instancia da conexao

        try {

            // Carregamento do JDBC Driver
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            // Configurar a conex�o
            String server = "localhost"; //caminho do MySQL
            String database = "db_produtos";
            String url = "jdbc:mysql://" + server + ":3306/" + database + "?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "Gremio1307";

            connection = DriverManager.getConnection(url, user, password);

            // Testando..
            if (connection != null) {
                System.out.println("Status: Conectado!");
            } else {
                System.out.println("Status: NAO CONECTADO!");
            }

            return connection;

        } catch (ClassNotFoundException e) {  //Driver n�o encontrado
            System.out.println("O driver nao foi encontrado. " + e.getMessage() );
            return null;

        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar...");
            return null;
        }
    }

    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        
        MinhaLista.clear(); // Limpa nosso ArrayList
      
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE tipo = 'Fone de Ouvido'");
            while (res.next()) {

                
                String conectividade_do_fone = res.getString("conectividade_do_fone");
                String material = res.getString("material");
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String tipo = res.getString("tipo");
                float preco = res.getFloat("preco");
                String descricao = res.getString("descricao");
                String marca = res.getString("marca");
                String modelo = res.getString("modelo");
                int qtd_estoque = res.getInt("qtd_estoque");
                String data_cadastro = res.getString("data_cadastro");
                
                
                

                Fone_de_Ouvido objeto = new Fone_de_Ouvido( conectividade_do_fone, material, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);

                MinhaLista.add(objeto);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo aluno
    public boolean InsertFoneBD(Fone_de_Ouvido objeto) {
        String sql = "INSERT INTO tb_produtos(id,nome,tipo,preco,descricao,marca,modelo,qtd_estoque,data_cadastro, conectividade_do_fone, material) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getTipo());
            stmt.setFloat(4, objeto.getPreco());
            stmt.setString(5, objeto.getDescricao());
            stmt.setString(6, objeto.getMarca());
            stmt.setString(7, objeto.getModelo());
            stmt.setInt(8, objeto.getQtd_estoque());
            stmt.setString(9, objeto.getData_cadastro());
            stmt.setString(10, objeto.getConectividade_do_fone());
            stmt.setString(11, objeto.getMaterial());
            

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    // Deleta um aluno especefico pelo seu campo ID
    public boolean DeleteFoneBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id = " + id);
            stmt.close();            
            
        } catch (SQLException erro) {
        }
        
        return true;
    }

    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateFoneBD(Fone_de_Ouvido objeto) {

        String sql = "UPDATE tb_produtos set nome = ? ,tipo = ? ,preco = ? ,descricao = ? , marca = ?,modelo = ?,qtd_estoque = ?,data_cadastro = ?,conectividade_do_fone = ?,material = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
           
            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getTipo());
            stmt.setFloat(3, objeto.getPreco());
            stmt.setString(4, objeto.getDescricao());
            stmt.setString(5, objeto.getMarca());
            stmt.setString(6, objeto.getModelo());
            stmt.setInt(7, objeto.getQtd_estoque());
            stmt.setString(8, objeto.getData_cadastro());
            stmt.setString(9, objeto.getConectividade_do_fone());
            stmt.setString(10, objeto.getMaterial());
            stmt.setInt(11, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public Fone_de_Ouvido carregaFone(int id) {
        
        Fone_de_Ouvido objeto = new Fone_de_Ouvido();
        objeto.setId(id);
        
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id = " + id + " AND tipo = 'Fone de Ouvido'");
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setTipo(res.getString("tipo"));
            objeto.setPreco(res.getFloat("preco"));
            objeto.setMarca(res.getString("marca"));
            objeto.setModelo(res.getString("modelo"));
            objeto.setQtd_estoque(res.getInt("qtd_estoque"));
            objeto.setData_cadastro(res.getString("data_cadastro"));
            objeto.setConectividade_do_fone(res.getString("conectividade_do_fone"));
            objeto.setMaterial(res.getString("material"));
            
            
            

            stmt.close();            
            
        } catch (SQLException erro) {
        }
        return objeto;
    }
    
   public ArrayList<Fone_de_Ouvido> getListaOrdenadaPorID() {
    ArrayList<Fone_de_Ouvido> listaOrdenada = new ArrayList<>();

    try (Connection conn = getConexao();
         Statement stmt = conn.createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos ORDER BY ID")) {

        while (res.next()) {
            Fone_de_Ouvido fone = new Fone_de_Ouvido(
                res.getString("conectividade_do_fone"),
                res.getString("material"),
                res.getInt("id"),
                res.getString("nome"),
                res.getString("tipo"),
                res.getFloat("preco"),
                res.getString("descricao"),
                res.getString("marca"),
                res.getString("modelo"),
                res.getInt("qtd_estoque"),
                res.getString("data_cadastro")
            );
            listaOrdenada.add(fone);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return listaOrdenada;
}
   public ArrayList<Fone_de_Ouvido> getListaOrdenadaPorPreco() {
    ArrayList<Fone_de_Ouvido> listaOrdenada = new ArrayList<>();

    try (Connection conn = getConexao();
         Statement stmt = conn.createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos ORDER BY preco")) {

        while (res.next()) {
            Fone_de_Ouvido fone = new Fone_de_Ouvido(
                res.getString("conectividade_do_fone"),
                res.getString("material"),
                res.getInt("id"),
                res.getString("nome"),
                res.getString("tipo"),
                res.getFloat("preco"),
                res.getString("descricao"),
                res.getString("marca"),
                res.getString("modelo"),
                res.getInt("qtd_estoque"),
                res.getString("data_cadastro")
            );
            listaOrdenada.add(fone);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return listaOrdenada;
}
   public ArrayList<Fone_de_Ouvido> getProdutosEsgotados() {
    ArrayList<Fone_de_Ouvido> produtosEsgotados = new ArrayList<>();

    try (Connection conn = getConexao();
         Statement stmt = conn.createStatement();
         ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE qtd_estoque = 0")) {

        while (res.next()) {
            Fone_de_Ouvido fone = new Fone_de_Ouvido(
                res.getString("conectividade_do_fone"),
                res.getString("material"),
                res.getInt("id"),
                res.getString("nome"),
                res.getString("tipo"),
                res.getFloat("preco"),
                res.getString("descricao"),
                res.getString("marca"),
                res.getString("modelo"),
                res.getInt("qtd_estoque"),
                res.getString("data_cadastro")
            );
            produtosEsgotados.add(fone);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return produtosEsgotados;
}
}
