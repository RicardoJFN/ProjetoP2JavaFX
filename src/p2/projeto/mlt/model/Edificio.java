/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author ricardon
 */
public class Edificio {
    
    //Definição de atributos da classe Edificio
    protected DoubleProperty primeiroPontoLat;
    protected DoubleProperty primeiroPontoLong;
    protected DoubleProperty segundoPontoLat;
    protected DoubleProperty segundoPontoLong;
    protected DoubleProperty terceiroPontoLat;
    protected DoubleProperty terceiroPontoLong;
    protected DoubleProperty quartoPontoLat;
    protected DoubleProperty quartoPontoLong;
   
    
    /**
     * Construtor da classe Cliente 
     * @param primeiroPonto
     * @param segundoPonto
     * @param terceiroPonto
     * @param quartoPonto
     */
    
    public Edificio(double primeiroPontoLat, double primeiroPontoLong, double segundoPontoLat, double segundoPontoLong, double terceiroPontoLat,
            double terceiroPontoLong, double quartoPontoLat, double quartoPontoLong){
        this.primeiroPontoLat = new SimpleDoubleProperty(primeiroPontoLat);
        this.primeiroPontoLong = new SimpleDoubleProperty(primeiroPontoLong);
        this.segundoPontoLat = new SimpleDoubleProperty(segundoPontoLat);
        this.segundoPontoLong = new SimpleDoubleProperty(segundoPontoLong);
        this.terceiroPontoLat = new SimpleDoubleProperty(terceiroPontoLat);
        this.terceiroPontoLong = new SimpleDoubleProperty(terceiroPontoLong);
        this.quartoPontoLat = new SimpleDoubleProperty(quartoPontoLat);
        this.quartoPontoLong = new SimpleDoubleProperty(quartoPontoLong);
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

        
    
    
    public void inserirEdificio(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO edificio(primeiro_ponto_lat,primeiro_ponto_long,segundo_ponto_lat,segundo_ponto_long,terceiro_ponto_lat,terceiro_ponto_long,quarto_ponto_lat,quarto_ponto_long) VALUES (?,?,?,?,?,?,?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setString(1, Double.toString(primeiroPontoLat.getValue()));
            ps.setString(2, Double.toString(primeiroPontoLong.getValue()));
            ps.setString(3, Double.toString(segundoPontoLat.getValue()));
            ps.setString(4, Double.toString(segundoPontoLong.getValue()));
            ps.setString(5, Double.toString(terceiroPontoLat.getValue()));
            ps.setString(6, Double.toString(terceiroPontoLong.getValue()));
            ps.setString(7, Double.toString(quartoPontoLat.getValue()));
            ps.setString(8, Double.toString(quartoPontoLong.getValue()));
        } catch (Exception e) {
        }
    }
}
