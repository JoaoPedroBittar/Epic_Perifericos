/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.TecladoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class Teclado extends Produto {

    private String dimensao;
    private String conectividade;
    private final TecladoDAO dao;

    public Teclado() {
        this.dao = new TecladoDAO();
    }

    public Teclado(String dimensao, String conectividade, TecladoDAO dao) {
        this.dimensao = dimensao;
        this.conectividade = conectividade;
        this.dao = new TecladoDAO();
    }

    public Teclado(String dimensao, String conectividade, int id, String nome, String tipo, float preco, String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) {
        super(id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);
        this.dimensao = dimensao;
        this.conectividade = conectividade;
        this.dao = new TecladoDAO();
    }



    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public String getConectividade() {
        return conectividade;
    }

    public void setConectividade(String conectividade) {
        this.conectividade = conectividade;
    }

 

    @Override
    public String toString() {
        return "\n ID: " + this.getId()
                + "\n Nome: " + this.getNome()
                + "\n Preço: " + this.getPreco()
                + "\n Tipo: " + this.getTipo()
                +"\n Dimensão: " + this.getDimensao()
                +"\n Conectividade: " + this.getConectividade()
                +"\n Modelo: " + this.getModelo()
                +"\n Marca: " + this.getMarca()
                + "\n Descrição:" + this.getDescricao()
                + "\n Quantidade de estoque:" + this.getQtd_estoque()
                + "\n Data de cadastro: " + this.getData_cadastro()
                + "\n -----------";
    }

    // Retorna a Lista de Teclados(objetos)
    public ArrayList getListaTeclado() {
        //return TecladosDAO.getListaTeclados;
        return dao.getListaTeclado();
    }

    // Cadastra novo Teclado
//    public boolean InsertTecladoBD(String tipo, String descricao, String nome, double preco) {
    public boolean InsertTecladoBD(String dimensao, String conectividade, String nome, String tipo, float preco, String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) throws SQLException {
        int id = this.maiorID() +1;
        Teclado objeto = new Teclado(dimensao, conectividade, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);
    //        TecladoDAO.ListaTeclado.add(objeto);
        dao.InsertTecladoBD(objeto);
        return true;

    }

    // Deleta um Teclado espec�fico pelo seu campo ID
    public boolean DeleteTecladoBD(int id) {
//        int indice = this.procuraIndice(id);
//        TecladosDAO.ListaTeclados.remove(indice);
        dao.DeleteTecladoBD(id);
        return true;

    }
    
     // Edita um aluno espec�fico pelo seu campo ID
    public boolean UpdateTecladoBD (String dimensao, String conectividade, int id, String nome, String tipo, float preco, String descricao, String marca, String modelo, int qtd_estoque, String data_cadastro) throws SQLException {
        Teclado objeto = new Teclado (dimensao, conectividade, id, nome, tipo, preco, descricao, marca, modelo, qtd_estoque, data_cadastro);
//        int indice = this.procuraIndice(id);
//        AlunoDAO.MinhaLista.set(indice, objeto);
        dao.UpdateTecladoBD(objeto);
        return true;
    }


    // carrega dados de um Teclado espec�fico pelo seu ID
    public Teclado carregaTeclado(int id) {
//        int indice = this.procuraIndice(id);
//        return TecladosDAO.getListaTeclados.get(indice);
        dao.carregaTeclado(id);
        return null;
    }

    // retorna o maior ID da nossa base de dados
    public int maiorID() throws SQLException {
   // public int maiorID(){
      // return TecladosDAO.maiorID();
        return dao.maiorID();
    }
}
