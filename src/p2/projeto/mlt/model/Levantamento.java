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


public class Levantamento {

	protected IntegerProperty idLevantamento;
	protected IntegerProperty dataLevantamento;
	protected ObjectProperty<Cliente> nomeCliente;
	protected ObjectProperty<Edificio> nomeEdificio;
	protected DoubleProperty primeiroPontoLat;
	protected DoubleProperty primeiroPontoLong;
	protected DoubleProperty segundoPontoLat;
	protected DoubleProperty segundoPontoLong;
	protected DoubleProperty terceiroPontoLat;
	protected DoubleProperty terceiroPontoLong;
	protected DoubleProperty quartoPontoLat;
	protected DoubleProperty quartoPontoLong;
	
	
	public Levantamento(int idLevantamento, int dataLevantamento, Cliente nomeCliente, Edificio nomeEdificio, double primeiroPontoLat, 
			double primeiroPontoLong, double segundoPontoLat, double segundoPontoLong, double terceiroPontoLat, double terceiroPontoLong, 
			double quartoPontoLat, double quartoPontoLong){
		this.idLevantamento = new SimpleIntegerProperty(idLevantamento);
		this.dataLevantamento = new SimpleIntegerProperty(dataLevantamento);
		this.nomeCliente = new SimpleObjectProperty<Cliente>(nomeCliente);
		this.nomeEdificio = new SimpleObjectProperty<Edificio>(nomeEdificio);
		this.primeiroPontoLat = new SimpleDoubleProperty(primeiroPontoLat);
		this.primeiroPontoLong = new SimpleDoubleProperty(primeiroPontoLong);
		this.segundoPontoLat = new SimpleDoubleProperty(segundoPontoLat);
		this.segundoPontoLong = new SimpleDoubleProperty(segundoPontoLong);
		this.terceiroPontoLat = new SimpleDoubleProperty(terceiroPontoLat);
		this.terceiroPontoLong = new SimpleDoubleProperty(terceiroPontoLong);
		this.quartoPontoLat = new SimpleDoubleProperty(quartoPontoLat);
		this.quartoPontoLong = new SimpleDoubleProperty(quartoPontoLong);
	}


	public IntegerProperty getIdLevantamento() {
		return idLevantamento;
	}


	public void setIdLevantamento(IntegerProperty idLevantamento) {
		this.idLevantamento = idLevantamento;
	}


	public IntegerProperty getDataLevantamento() {
		return dataLevantamento;
	}


	public void setDataLevantamento(IntegerProperty dataLevantamento) {
		this.dataLevantamento = dataLevantamento;
	}



	public ObjectProperty<Cliente> getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(ObjectProperty<Cliente> nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public ObjectProperty<Edificio> getNomeEdificio() {
		return nomeEdificio;
	}


	public void setNomeEdificio(ObjectProperty<Edificio> nomeEdificio) {
		this.nomeEdificio = nomeEdificio;
	}


	public DoubleProperty getPrimeiroPontoLat() {
		return primeiroPontoLat;
	}


	public void setPrimeiroPontoLat(DoubleProperty primeiroPontoLat) {
		this.primeiroPontoLat = primeiroPontoLat;
	}


	public DoubleProperty getPrimeiroPontoLong() {
		return primeiroPontoLong;
	}


	public void setPrimeiroPontoLong(DoubleProperty primeiroPontoLong) {
		this.primeiroPontoLong = primeiroPontoLong;
	}


	public DoubleProperty getSegundoPontoLat() {
		return segundoPontoLat;
	}


	public void setSegundoPontoLat(DoubleProperty segundoPontoLat) {
		this.segundoPontoLat = segundoPontoLat;
	}


	public DoubleProperty getSegundoPontoLong() {
		return segundoPontoLong;
	}


	public void setSegundoPontoLong(DoubleProperty segundoPontoLong) {
		this.segundoPontoLong = segundoPontoLong;
	}


	public DoubleProperty getTerceiroPontoLat() {
		return terceiroPontoLat;
	}


	public void setTerceiroPontoLat(DoubleProperty terceiroPontoLat) {
		this.terceiroPontoLat = terceiroPontoLat;
	}


	public DoubleProperty getTerceiroPontoLong() {
		return terceiroPontoLong;
	}


	public void setTerceiroPontoLong(DoubleProperty terceiroPontoLong) {
		this.terceiroPontoLong = terceiroPontoLong;
	}


	public DoubleProperty getQuartoPontoLat() {
		return quartoPontoLat;
	}


	public void setQuartoPontoLat(DoubleProperty quartoPontoLat) {
		this.quartoPontoLat = quartoPontoLat;
	}


	public DoubleProperty getQuartoPontoLong() {
		return quartoPontoLong;
	}


	public void setQuartoPontoLong(DoubleProperty quartoPontoLong) {
		this.quartoPontoLong = quartoPontoLong;
	}


	
	@Override
	public String toString() {
		return "Levantamento [idLevantamento=" + idLevantamento + ", dataLevantamento=" + dataLevantamento
				+ ", nomeCliente=" + nomeCliente + ", nomeEdificio=" + nomeEdificio + ", primeiroPontoLat="
				+ primeiroPontoLat + ", primeiroPontoLong=" + primeiroPontoLong + ", segundoPontoLat=" + segundoPontoLat
				+ ", segundoPontoLong=" + segundoPontoLong + ", terceiroPontoLat=" + terceiroPontoLat
				+ ", terceiroPontoLong=" + terceiroPontoLong + ", quartoPontoLat=" + quartoPontoLat
				+ ", quartoPontoLong=" + quartoPontoLong + "]";
	}
	
	
	
	
	
	public void inserirNovoLevantamento(Levantamento levantamento){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO levantamento(Lev_id,Lev_data,Lev_nomecliente,Lev_nomeedificio,Lev_latp1,Lev_longp1,Lev_latp2,Lev_longp2,Lev_latp3,Lev_longp3,Lev_latp4,Lev_longp4)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setInt(1, idLevantamento.getValue());
			ps.setInt(2, dataLevantamento.getValue());
			ps.setInt(3, nomeCliente.getValue().getIdCliente().getValue());
			ps.setInt(4, nomeEdificio.getValue().getIdEdificio().getValue());
			ps.setDouble(5, primeiroPontoLat.getValue());
			ps.setDouble(6, primeiroPontoLong.getValue());
			ps.setDouble(7, segundoPontoLat.getValue());
			ps.setDouble(8, segundoPontoLong.getValue());
			ps.setDouble(9, terceiroPontoLat.getValue());
			ps.setDouble(10, terceiroPontoLong.getValue());
			ps.setDouble(11, quartoPontoLat.getValue());
			ps.setDouble(12, quartoPontoLong.getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
