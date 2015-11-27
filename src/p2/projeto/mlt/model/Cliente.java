/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author ricardon
 */
public class Cliente {
    
    
    /**
     * Definição de atributos da classe Cliente
     */
    
    protected StringProperty nome;
    protected StringProperty morada;
    protected IntegerProperty codigoPostal;
    protected StringProperty localidade;
    protected StringProperty pais;
    protected IntegerProperty contactoTelefone;
    protected IntegerProperty contactoTelemovel;
    protected StringProperty contactoEmail;
    
    /**
     * Construtor da classe Cliente 
     * @param nome
     * @param morada
     * @param codigoPostal
     * @param localidade
     * @param pais
     * @param contactoTelefone
     * @param contactoTelemovel
     * @param contactoEmail
     */
    
    public Cliente(String nome, String morada, int codigoPostal, String localidade, String pais, int contactoTelefone,
            int contactoTelemovel, String contactoEmail){
        
        this.nome = new SimpleStringProperty(nome);
        this.morada = new SimpleStringProperty(morada);
        this.codigoPostal = new SimpleIntegerProperty(codigoPostal);
        this.localidade = new SimpleStringProperty(localidade);
        this.pais = new SimpleStringProperty(pais);
        this.contactoTelefone = new SimpleIntegerProperty(contactoTelefone);
        this.contactoTelemovel = new SimpleIntegerProperty(contactoTelemovel);
        this.contactoEmail = new SimpleStringProperty(contactoEmail);
    }
    
    /**
     * Método de inserção de um novo cliente na base de dados
     * @param cliente
     */
    public void inserirNovoCliente(Cliente cliente){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO cliente(Cliente_name,Cliente_morada,Cliente_postal,Cliente_local,Cliente_telef,Cliente_telem,Cliente_email) VALUES (?,?,?,?,?,?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setString(1, nome.getValue());
            ps.setString(2, morada.getValue());
            ps.setString(3, Integer.toString(codigoPostal.getValue()));
            ps.setString(4, localidade.getValue());
            ps.setString(5, pais.getValue());
            ps.setString(6, Integer.toString(contactoTelefone.getValue()));
            ps.setString(7, Integer.toString(contactoTelemovel.getValue()));
            ps.setString(8, contactoEmail.getValue());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
