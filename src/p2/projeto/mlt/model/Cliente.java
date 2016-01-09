/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

public class Cliente {
	
	/**
	 * Definicao de atributos da classe Cliente
	 */

	protected IntegerProperty idCliente;
	protected StringProperty nomeCliente;
	protected StringProperty moradaCliente;
	protected DoubleProperty codigoPostal;
	protected IntegerProperty numeroTelefone;
	protected IntegerProperty numeroTelemovel;
	protected StringProperty emailCliente;
	
	
	/**
	 * Construtor do Cliente com o ID como campo obrigatorio
	 * @param idCliente
	 * @param nomeCliente
	 * @param moradaCliente
	 * @param codigoPostal
	 * @param numeroTelefone
	 * @param numeroTelemovel
	 * @param emailCliente
	 */
        
	public Cliente(int idCliente, String nomeCliente, String moradaCliente, double codigoPostal, 
			int numeroTelefone, int numeroTelemovel, String emailCliente){
		this.idCliente = new SimpleIntegerProperty(idCliente);
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.moradaCliente = new SimpleStringProperty(moradaCliente);
		this.codigoPostal = new SimpleDoubleProperty(codigoPostal);
		this.numeroTelefone = new SimpleIntegerProperty(numeroTelefone);
		this.numeroTelemovel = new SimpleIntegerProperty(numeroTelemovel);
		this.emailCliente = new SimpleStringProperty(emailCliente);
	}
	
	/**
	 * Construtor do Cliente sem o ID como campo obrigatorio
	 * @param nomeCliente
	 * @param moradaCliente
	 * @param codigoPostal
	 * @param numeroTelefone
	 * @param numeroTelemovel
	 * @param emailCliente
	 */
        
	public Cliente(String nomeCliente, String moradaCliente, double codigoPostal, 
			int numeroTelefone, int numeroTelemovel, String emailCliente){
		this.nomeCliente = new SimpleStringProperty(nomeCliente);
		this.moradaCliente = new SimpleStringProperty(moradaCliente);
		this.codigoPostal = new SimpleDoubleProperty(codigoPostal);
		this.numeroTelefone = new SimpleIntegerProperty(numeroTelefone);
		this.numeroTelemovel = new SimpleIntegerProperty(numeroTelemovel);
		this.emailCliente = new SimpleStringProperty(emailCliente);
	}
        
        /**
	 * Construtor do Cliente com o ID como campo obrigatorio
	 * @param idCliente
	 * @param nomeCliente
	 */
        
        public Cliente(int idCliente, String nomeCliente){
            this.idCliente = new SimpleIntegerProperty(idCliente);
            this.nomeCliente = new SimpleStringProperty(nomeCliente);
        }
        
	//-------------------------------------------------------Getters e Setters-------------------------------------------------------

	public IntegerProperty getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(IntegerProperty idCliente) {
		this.idCliente = idCliente;
	}

	public StringProperty getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(StringProperty nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public StringProperty getMoradaCliente() {
		return moradaCliente;
	}

	public void setMoradaCliente(StringProperty moradaCliente) {
		this.moradaCliente = moradaCliente;
	}

	public DoubleProperty getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(DoubleProperty codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	
	public IntegerProperty getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(IntegerProperty numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public IntegerProperty getNumeroTelemovel() {
		return numeroTelemovel;
	}

	public void setNumeroTelemovel(IntegerProperty numeroTelemovel) {
		this.numeroTelemovel = numeroTelemovel;
	}

	public StringProperty getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(StringProperty emailCliente) {
		this.emailCliente = emailCliente;
	}

	
	//-------------------------------------------------------Metodo toString()-------------------------------------------------------
	
	@Override
	public String toString() {
		return "Cliente: " + nomeCliente.getValue();
	}
	
	//-------------------------------------------------------Metodo de insercao de um novo cliente na BD-------------------------------------------------------
	
	public void inserirNovoCliente(Cliente cliente){
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO cliente(Cliente_nome,Cliente_morada,Cliente_postal,Cliente_telef,Cliente_telem,Cliente_email) VALUES(?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setString(1, nomeCliente.getValue());
			ps.setString(2, moradaCliente.getValue());
			ps.setDouble(3, codigoPostal.getValue());
			ps.setInt(4, numeroTelefone.getValue());
			ps.setInt(5, numeroTelemovel.getValue());
			ps.setString(6, emailCliente.getValue());
			
			
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
        /**
         * 
         * Metodo que retorna uma ArrayList do tipo String para devolver apenas o nome do cliente 
         * 
         * @return 
         */        
        
	public static ArrayList<String> selecionaNomesCliente(){
		
		ArrayList<String> nomes = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Cliente_nome FROM cliente");
			
			while(rs.next()){
				nomes.add(rs.getString("Cliente_nome"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return nomes;
	}
	
        /**
         * Metodo que retorna uma ArrayList do tipo Edificio e devolve os seguintes
         * dados nome e ID do edificio.
         * Edif_id e uma Foreing Key na base de dados.
         * @return 
         */
        
        public static ArrayList<Cliente> selecionaCliente(){
		
		ArrayList<Cliente> nomes = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
			
			while(rs.next()){
				nomes.add(new Cliente(rs.getInt("Cliente_id"), rs.getString("Cliente_nome"), rs.getString("Cliente_morada"), rs.getDouble("Cliente_postal"), rs.getInt("Cliente_telef"), 
                                        rs.getInt("Cliente_telem"), rs.getString("Cliente_email")));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return nomes;
	}
       
	
	
}
