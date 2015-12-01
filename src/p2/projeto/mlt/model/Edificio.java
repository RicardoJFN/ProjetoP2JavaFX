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
    protected DoubleProperty primeiroPonto;
    protected DoubleProperty segundoPonto;
    protected DoubleProperty terceiroPonto;
    protected DoubleProperty quartoPonto;
   
    
    /**
     * Construtor da classe Cliente 
     * @param primeiroPonto
     * @param segundoPonto
     * @param terceiroPonto
     * @param quartoPonto
     */
    
    public Edificio(double primeiroPonto, double segundoPonto, double terceiroPonto, double quartoPonto){
        this.primeiroPonto = new SimpleDoubleProperty(primeiroPonto);
        this.segundoPonto = new SimpleDoubleProperty(segundoPonto);
        this.terceiroPonto = new SimpleDoubleProperty(terceiroPonto);
        this.quartoPonto = new SimpleDoubleProperty(quartoPonto);
    }

    public DoubleProperty getPrimeiroPonto() {
        return primeiroPonto;
    }

    public void setPrimeiroPonto(DoubleProperty primeiroPonto) {
        this.primeiroPonto = primeiroPonto;
    }

    public DoubleProperty getSegundoPonto() {
        return segundoPonto;
    }

    public void setSegundoPonto(DoubleProperty segundoPonto) {
        this.segundoPonto = segundoPonto;
    }

    public DoubleProperty getTerceiroPonto() {
        return terceiroPonto;
    }

    public void setTerceiroPonto(DoubleProperty terceiroPonto) {
        this.terceiroPonto = terceiroPonto;
    }

    public DoubleProperty getQuartoPonto() {
        return quartoPonto;
    }

    public void setQuartoPonto(DoubleProperty quartoPonto) {
        this.quartoPonto = quartoPonto;
    }
    
    public void inserirEdificio(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO edificio(primeiro_ponto,segundo_ponto,terceiro_ponto,quarto_ponto) VALUES (?,?,?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setString(1, Double.toString(primeiroPonto.getValue()));
            ps.setString(2, Double.toString(segundoPonto.getValue()));
            ps.setString(3, Double.toString(terceiroPonto.getValue()));
            ps.setString(4, Double.toString(quartoPonto.getValue()));
        } catch (Exception e) {
        }
    }
}
