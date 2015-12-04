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
    
    protected IntegerProperty edificioID;
    protected StringProperty nomeCliente;
    protected IntegerProperty numeroEdificio;
    protected StringProperty nomeEdificio;
    protected DoubleProperty coordLat;
    protected DoubleProperty coordLong;
    
    
    public Edificio(String nomeCliente, int numeroEdificio, String nomeEdificio, double coordLat, double coordLong){
        this.nomeCliente = new SimpleStringProperty(nomeCliente);
        this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
        this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
        this.coordLat = new SimpleDoubleProperty(coordLat);
        this.coordLong = new SimpleDoubleProperty(coordLong);
    }
    
    public Edificio(int edificioID, String nomeCliente, int numeroEdificio, String nomeEdificio, double coordLat, double coordLong){
        this.numeroEdificio = new SimpleIntegerProperty(edificioID);
        this.nomeCliente = new SimpleStringProperty(nomeCliente);
        this.numeroEdificio = new SimpleIntegerProperty(numeroEdificio);
        this.nomeEdificio = new SimpleStringProperty(nomeEdificio);
        this.coordLat = new SimpleDoubleProperty(coordLat);
        this.coordLong = new SimpleDoubleProperty(coordLong);
    }

    public IntegerProperty getEdificioID() {
        return edificioID;
    }

    public void setEdificioID(IntegerProperty edificioID) {
        this.edificioID = edificioID;
    }
    
    

    public StringProperty getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(StringProperty nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public DoubleProperty getCoordLat() {
        return coordLat;
    }

    public void setCoordLat(DoubleProperty coordLat) {
        this.coordLat = coordLat;
    }

    public DoubleProperty getCoordLong() {
        return coordLong;
    }

    public void setCoordLong(DoubleProperty coordLong) {
        this.coordLong = coordLong;
    }

    

    public void inserirEdificio(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO edificios(Edif_num,Edif_nome,Edif_lat,Edif_long) VALUES (?,?,?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setString(1, Integer.toString(numeroEdificio.getValue()));
            ps.setString(2, nomeEdificio.getValue());
            ps.setString(3, Double.toString(coordLat.getValue()));
            ps.setString(4, Double.toString(coordLong.getValue()));
            
        } catch (Exception e) {
        }
    }
}
