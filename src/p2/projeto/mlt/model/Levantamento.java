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
	protected DoubleProperty numLevantamento;
	protected IntegerProperty dataLevantamento;
	protected DoubleProperty primeiroPontoLat;
	protected DoubleProperty primeiroPontoLong;
	protected DoubleProperty segundoPontoLat;
	protected DoubleProperty segundoPontoLong;
	protected DoubleProperty terceiroPontoLat;
	protected DoubleProperty terceiroPontoLong;
	protected DoubleProperty quartoPontoLat;
	protected DoubleProperty quartoPontoLong;
        protected DoubleProperty calculoArea;
        protected ObjectProperty<Edificio> numeroEdificio;
	
	
	public Levantamento(double numLevantamento, int dataLevantamento, double primeiroPontoLat, 
			double primeiroPontoLong, double segundoPontoLat, double segundoPontoLong, double terceiroPontoLat, double terceiroPontoLong, 
			double quartoPontoLat, double quartoPontoLong, double calculoArea,Edificio numeroEdificio){
		this.numLevantamento = new SimpleDoubleProperty(numLevantamento);
		this.dataLevantamento = new SimpleIntegerProperty(dataLevantamento);
		this.primeiroPontoLat = new SimpleDoubleProperty(primeiroPontoLat);
		this.primeiroPontoLong = new SimpleDoubleProperty(primeiroPontoLong);
		this.segundoPontoLat = new SimpleDoubleProperty(segundoPontoLat);
		this.segundoPontoLong = new SimpleDoubleProperty(segundoPontoLong);
		this.terceiroPontoLat = new SimpleDoubleProperty(terceiroPontoLat);
		this.terceiroPontoLong = new SimpleDoubleProperty(terceiroPontoLong);
		this.quartoPontoLat = new SimpleDoubleProperty(quartoPontoLat);
		this.quartoPontoLong = new SimpleDoubleProperty(quartoPontoLong);
                this.calculoArea = new SimpleDoubleProperty(calculoArea);
                this.numeroEdificio = new SimpleObjectProperty<>(numeroEdificio);
	}
        
        public Levantamento(int idLevantamento, double numLevantamento, int dataLevantamento, double primeiroPontoLat, 
			double primeiroPontoLong, double segundoPontoLat, double segundoPontoLong, double terceiroPontoLat, double terceiroPontoLong, 
			double quartoPontoLat, double quartoPontoLong, Edificio numeroEdificio){
                this.idLevantamento = new SimpleIntegerProperty(idLevantamento);
		this.numLevantamento = new SimpleDoubleProperty(numLevantamento);
		this.dataLevantamento = new SimpleIntegerProperty(dataLevantamento);
		this.primeiroPontoLat = new SimpleDoubleProperty(primeiroPontoLat);
		this.primeiroPontoLong = new SimpleDoubleProperty(primeiroPontoLong);
		this.segundoPontoLat = new SimpleDoubleProperty(segundoPontoLat);
		this.segundoPontoLong = new SimpleDoubleProperty(segundoPontoLong);
		this.terceiroPontoLat = new SimpleDoubleProperty(terceiroPontoLat);
		this.terceiroPontoLong = new SimpleDoubleProperty(terceiroPontoLong);
		this.quartoPontoLat = new SimpleDoubleProperty(quartoPontoLat);
		this.quartoPontoLong = new SimpleDoubleProperty(quartoPontoLong);
                this.numeroEdificio = new SimpleObjectProperty<>(numeroEdificio);
	}

        public Levantamento(int idLevantamento, double numLevantamento){
            this.idLevantamento = new SimpleIntegerProperty(idLevantamento);
            this.numLevantamento = new SimpleDoubleProperty(numLevantamento);
        }
        
        
        public IntegerProperty getIdLevantamento() {
            return idLevantamento;
        }
        
        public void setIdLevantamento(IntegerProperty idLevantamento) {
            this.idLevantamento = idLevantamento;
        }
        
        
	public DoubleProperty getNumLevantamento() {
		return numLevantamento;
	}


	public void setNumLevantamento(DoubleProperty numLevantamento) {
		this.numLevantamento = numLevantamento;
	}


	public IntegerProperty getDataLevantamento() {
		return dataLevantamento;
	}


	public void setDataLevantamento(IntegerProperty dataLevantamento) {
		this.dataLevantamento = dataLevantamento;
	}

    public ObjectProperty<Edificio> getNumeroEdificio() {
        return numeroEdificio;
    }

    public void setNumeroEdificio(ObjectProperty<Edificio> numeroEdificio) {
        this.numeroEdificio = numeroEdificio;
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

    public DoubleProperty getCalculoArea() {
        return calculoArea;
    }

    public void setCalculoArea(DoubleProperty calculoArea) {
        this.calculoArea = calculoArea;
    }


        
	
	@Override
	public String toString() {
		return "Número: " + numLevantamento.getValue();
	}
	
	
	
	
	
	public void inserirNovoLevantamento(){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO levantamento(Lev_num,Lev_data,Lev_latp1,Lev_longp1,Lev_latp2,Lev_latp3,Lev_latp4,Lev_longp2,Lev_longp3,Lev_longp4,Lev_area,Lev_Edif_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setDouble(1, numLevantamento.getValue());
			ps.setInt(2, dataLevantamento.getValue());
			ps.setDouble(3, primeiroPontoLat.getValue());
			ps.setDouble(4, primeiroPontoLong.getValue());
			ps.setDouble(5, segundoPontoLat.getValue());
			ps.setDouble(6, terceiroPontoLat.getValue());
			ps.setDouble(7, quartoPontoLat.getValue());
			ps.setDouble(8, segundoPontoLong.getValue());
			ps.setDouble(9, terceiroPontoLong.getValue());
			ps.setDouble(10, quartoPontoLong.getValue());
                        ps.setDouble(11, calculoArea.getValue());
                        ps.setInt(12, numeroEdificio.getValue().getIdEdificio().getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
        
        public static ArrayList<Levantamento> selecionaLevantamento(){
		
		ArrayList<Levantamento> levantamentos = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM levantamento");
			
			while(rs.next()){
				levantamentos.add(new Levantamento(rs.getInt("Lev_id"), rs.getDouble("Lev_num")));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return levantamentos;
	}
        
}
