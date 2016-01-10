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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author pedror
 */
public class Edificio {

    
        /**
         * Definicao de atributos da classe Edificio
         */
    
	protected IntegerProperty idEdificio;
	protected ObjectProperty<Cliente> cliente;
	protected IntegerProperty numeroEdificio;
	protected StringProperty nomeEdificio;
	protected DoubleProperty latCoordEdificio;
	protected DoubleProperty longCoordEdificio;
	
        
        /**
	 * Construtor do Edificio com o ID como campo obrigatorio
	 * @param idEdificio
	 * @param cliente
	 * @param numeroEdificio
	 * @param nomeEdificio
	 * @param latCoordEdificio
	 * @param longCoordEdificio
	 */
              
	public Edificio(int idEdificio, Cliente cliente, int numeroEdificio, String nomeEdificio, double latCoordEdificio, double longCoordEdificio){
		this.idEdificio = new SimpleIntegerProperty(idEdificio);
		this.cliente = new SimpleObjectProperty<>(cliente);
		this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
		this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
		this.latCoordEdificio = new SimpleDoubleProperty(latCoordEdificio);
		this.longCoordEdificio = new SimpleDoubleProperty(longCoordEdificio);
	}
	
        
        /**
	 * Construtor do Edificio sem o ID como campo obrigatorio
	 * @param cliente
	 * @param numeroEdificio
	 * @param nomeEdificio
	 * @param latCoordEdificio
	 * @param longCoordEdificio
	 */
        
	public Edificio(Cliente cliente, int numeroEdificio, String nomeEdificio, double latCoordEdificio, double longCoordEdificio){
		this.cliente = new SimpleObjectProperty<>(cliente);
		this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
		this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
		this.latCoordEdificio = new SimpleDoubleProperty(latCoordEdificio);
		this.longCoordEdificio = new SimpleDoubleProperty(longCoordEdificio);
	}
        
        /**
	 * Construtor do Edificio com o ID como campo obrigatorio
	 * @param idEdificio
	 * @param nomeEdificio
	 */
        
        public Edificio(int idEdificio, String nomeEdificio){
            this.idEdificio = new SimpleIntegerProperty(idEdificio);
            this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
        }

        public Edificio(int idEdificio){
            this.idEdificio = new SimpleIntegerProperty(idEdificio);
           }
        
        //-------------------------------------------------------Getters e Setters-------------------------------------------------------
        
	public IntegerProperty getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(IntegerProperty idEdificio) {
		this.idEdificio = idEdificio;
	}

        public ObjectProperty<Cliente> getCliente() {
                return cliente;
        }

        public void setCliente(ObjectProperty<Cliente> cliente) {
            this.cliente = cliente;
        }

	public IntegerProperty getNumeroEdificio() {
		return numeroEdificio;
	}

	public void setNumeroEdificio(IntegerProperty numeroEdificio) {
		this.numeroEdificio = numeroEdificio;
	}

	public StringProperty getNomeEdificio() {
		return nomeEdificio;
	}

	public void setNomeEdificio(StringProperty nomeEdificio) {
		this.nomeEdificio = nomeEdificio;
	}

	public DoubleProperty getLatCoordEdificio() {
		return latCoordEdificio;
	}

	public void setLatCoordEdificio(DoubleProperty latCoordEdificio) {
		this.latCoordEdificio = latCoordEdificio;
	}

	public DoubleProperty getLongCoordEdificio() {
		return longCoordEdificio;
	}

	public void setLongCoordEdificio(DoubleProperty longCoordEdificio) {
		this.longCoordEdificio = longCoordEdificio;
	}

	/**
         * 
         * Metodo toString que retorna o nome do edificio
         * 
         * @return 
         */
	
	@Override
	public String toString() {
		return "Edificio: " + nomeEdificio.getValue() + " - " + idEdificio.getValue();
	}

        /**
         * 
         * Metodo usado para inserir informacao na base de dados na tabela edificios
         *  
         */
        
	public void inserirNovoEdificio(){
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO edificios(Edif_num,Edif_nome,Edif_lat,Edif_long,Edif_Cliente_id) VALUES(?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setInt(1, numeroEdificio.getValue());
			ps.setString(2, nomeEdificio.getValue());
			ps.setDouble(3, latCoordEdificio.getValue());
			ps.setDouble(4, longCoordEdificio.getValue());
			ps.setInt(5, cliente.getValue().getIdCliente().getValue());
			
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
        /**
         * 
         * Metodo que retorna uma ArrayList do tipo String para devolver apenas o nome do edificio 
         * 
         * @return 
         */
        
	public static ArrayList<String> selecionaNomesEdificio(){
			
			ArrayList<String> nomes = new ArrayList<>();
			try{
				ConexaoBaseDados con = ConexaoBaseDados.conectar();
				Statement stmt = con.getConexao().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM edificios");
				
				while(rs.next()){
					nomes.add(rs.getString("Edif_nome"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return nomes;
		}
        
        /**
         * 
         * Metodo que retorna uma ArrayList do tipo Edificio e devolve os seguintes
         * dados nome e ID do edificio.
         * Edif_id e uma Foreing Key na base de dados.
         * @return 
         */
        
        public static ArrayList<Edificio> selecionaEdificio(){
		
		ArrayList<Edificio> edificios = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM edificios");
			
              
			while(rs.next()){
				edificios.add(new Edificio(rs.getInt("Edif_id"), rs.getString("Edif_nome")));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return edificios;
	}
        
        public static ArrayList<Edificio> selecionaIDEdificio(){
		
		ArrayList<Edificio> edificios = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM edificios");
			
              
			while(rs.next()){
				edificios.add(new Edificio(rs.getInt("Edif_id")));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return edificios;
	}
}
