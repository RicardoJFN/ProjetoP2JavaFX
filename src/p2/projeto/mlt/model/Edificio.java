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

public class Edificio {

	protected IntegerProperty idEdificio;
	protected ObjectProperty<Cliente> cliente;
	protected IntegerProperty numeroEdificio;
	protected StringProperty nomeEdificio;
	protected DoubleProperty latCoordEdificio;
	protected DoubleProperty longCoordEdificio;
	
	public Edificio(int idEdificio, Cliente cliente, int numeroEdificio, String nomeEdificio, double latCoordEdificio, double longCoordEdificio){
		this.idEdificio = new SimpleIntegerProperty(idEdificio);
		this.cliente = new SimpleObjectProperty<Cliente>(cliente);
		this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
		this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
		this.latCoordEdificio = new SimpleDoubleProperty(latCoordEdificio);
		this.longCoordEdificio = new SimpleDoubleProperty(longCoordEdificio);
	}
	
	public Edificio(Cliente cliente, int numeroEdificio, String nomeEdificio, double latCoordEdificio, double longCoordEdificio){
		this.cliente = new SimpleObjectProperty<Cliente>(cliente);
		this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
		this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
		this.latCoordEdificio = new SimpleDoubleProperty(latCoordEdificio);
		this.longCoordEdificio = new SimpleDoubleProperty(longCoordEdificio);
	}

	public IntegerProperty getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(IntegerProperty idEdificio) {
		this.idEdificio = idEdificio;
	}

	public ObjectProperty<Cliente> getNomeCliente() {
		return cliente;
	}

	public void setNomeCliente(ObjectProperty<Cliente> nomeCliente) {
		this.cliente = nomeCliente;
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

	
	
	@Override
	public String toString() {
		return "Edificio [nomeEdificio=" + nomeEdificio + "]";
	}

	public void inserirNovoEdificio(){
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO edificios(Edif_id,Edif_num,Edfi_nome,Edif_lat,Edif_long,Edfi_Cliente_id) VALUES(?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setInt(1, idEdificio.getValue());
			ps.setInt(2, numeroEdificio.getValue());
			ps.setString(3, nomeEdificio.getValue());
			ps.setDouble(4, latCoordEdificio.getValue());
			ps.setDouble(5, longCoordEdificio.getValue());
			ps.setInt(6, cliente.getValue().getIdCliente().getValue());
			
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Edificio> selecionaNomesEdificio(){
			
			ArrayList<Edificio> nomes = new ArrayList<>();
			try{
				ConexaoBaseDados con = ConexaoBaseDados.conectar();
				Statement stmt = con.getConexao().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM edificios");
				
				while(rs.next()){
					nomes.add(new Edificio((Cliente) rs.getObject("cliente"), rs.getInt("numeroEdificio"), rs.getString("nomeEdificio"), rs.getDouble("latCoordEdificio"), 
							rs.getDouble("longCoordEdificio")));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			return nomes;
		}
}
