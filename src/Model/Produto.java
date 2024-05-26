package Model;
import java.util.Date;

public class Produto {

    // Atributos
    private int id;
    private String nome;
    private String tipo;
    private float preco;
    private String descricao;
    private String marca;
    private String modelo;
    private int qtd_estoque;
    private String data_cadastro;
    
    
    // M�todo Construtor de Objeto Vazio
    public Produto() {
    }

    // M�todo Construtor de Objeto, inserindo dados
    public Produto(int id, String nome, String tipo, float preco, String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.qtd_estoque = qtd_estoque;
        this.data_cadastro = data_cadastro;
        
    }

    // M�todos GET e SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
     public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }
    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
     
    
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Tipo: " + this.getTipo()
                + "\n Preço: " + this.getPreco()
                + "\n Descricao: " + this.getDescricao()
                + "\n Marca: " + this.getMarca()
                + "\n Modelo: " + this.getModelo()
                + "\n Quantidade em Estoque: " + this.getQtd_estoque()
                + "\n Data de Cadastro: " + this.getData_cadastro();
                
    }
}