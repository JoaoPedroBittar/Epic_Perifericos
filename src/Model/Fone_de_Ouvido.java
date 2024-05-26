package Model;

import java.util.*;
import DAO.Fone_de_OuvidoDAO;
import java.sql.SQLException;

public class Fone_de_Ouvido extends Produto {
    
    
    
    
    private String conectividade_do_fone; //Com fio ou sem fio
    private String material;
    private final Fone_de_OuvidoDAO dao;
    
    // M�todo Construtor de Objeto Vazio
    public Fone_de_Ouvido(){
        this.dao = new Fone_de_OuvidoDAO(); // inicializado n�o importa em qual construtor
    }
    
    // M�todo Construtor de Objeto, inserindo dados

    public Fone_de_Ouvido(String conectividade_do_fone, String material) {
        
        this.conectividade_do_fone = conectividade_do_fone;
        this.material = material;       
        this.dao = new Fone_de_OuvidoDAO(); // inicializado nao importa em qual construtor
    }
    
    // M�todo Construtor usando tamb�m o construtor da SUPERCLASSE
    public Fone_de_Ouvido(String conectividade_do_fone, String material, int id, String nome, String tipo,float preco,
           String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) {
            
        super(id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);       
        this.material = material;
        this.conectividade_do_fone = conectividade_do_fone;
        
        this.dao = new Fone_de_OuvidoDAO(); // inicializado n�o importa em qual construtor
    
    }


    public String getConectividade_do_fone() {
        return conectividade_do_fone;
    }

    public void setConectividade_do_fone(String conectividade_do_fone) {
        this.conectividade_do_fone = conectividade_do_fone;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

   
    
    @Override
    public String toString() {
        return  "\n"+ super.toString()
        + "\n conectividade_do_fone " + this.getConectividade_do_fone()
        + "\n Material " + this.getMaterial();
        
    }
/*
    
        ABAIXO OS M�TODOS PARA USO JUNTO COM O DAO
        SIMULANDO A ESTRUTURA EM CAMADAS PARA USAR COM BANCOS DE DADOS.
    
     */
    // Retorna a Lista de Fone_de_ouvido(objetos)
    public ArrayList getMinhaLista() {
        //return Fone_de_ouvidoDAO.MinhaLista;
        return dao.getMinhaLista();

    }
    // Cadastra novo Fone
    public boolean InsertFoneBD( String conectividade_do_fone, String material,String nome, String tipo, float preco,
            String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) throws SQLException {
        int id = this.maiorID() + 1;
        Fone_de_Ouvido objeto = new Fone_de_Ouvido(conectividade_do_fone, material, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);
        dao.InsertFoneBD(objeto);
        return true;

    }
    // Deleta um aluno espec�fico pelo seu campo ID
    public boolean DeleteFoneBD(int id) {
        dao.DeleteFoneBD(id);
        return true;
    }
    // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateFoneBD(String conectividade_do_fone, String material, int id, String nome, String tipo, float preco, 
        String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) {
        Fone_de_Ouvido objeto = new Fone_de_Ouvido(conectividade_do_fone, material, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.UpdateFoneBD(objeto);
        return true;
    }
    // carrega dados de um Fone espec�fico pelo seu ID
    public Fone_de_Ouvido carregaFone(int id) {
        dao.carregaFone(id);
        return null;
    }
    // retorna o maior ID da nossa base de dados
        public int maiorID() throws SQLException{
        return dao.maiorID();
    }
}
