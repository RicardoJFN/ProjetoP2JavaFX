/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.time.LocalDate;
import java.time.Month;
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
 * @author ricardon
 */
public class Levantamento {
    
    //Definição de atributos da classe Levantamento
    protected IntegerProperty numero;
    protected ObjectProperty<LocalDate> data;
    protected StringProperty nomeCliente;
    protected StringProperty nomeEdifcio;
    protected DoubleProperty primeiroPonto;
    protected DoubleProperty segundoPonto;
    
    
    /**
     * Construtor da classe Levantamento 
     * @param numero
     * @param data
     * @param nomeCliente
     * @param nomeEdificio
     * @param primeiroPonto
     * @param segundoPonto
     */
    
    public Levantamento(int numero, LocalDate data, String nomeCliente, String nomeEdificio, double primeiroPonto, double segundoPonto){
        this.numero = new SimpleIntegerProperty(numero);
        this.data = new SimpleObjectProperty<>(data);
        this.nomeCliente = new SimpleStringProperty(nomeCliente);
        this.nomeEdifcio = new SimpleStringProperty(nomeEdificio);
        this.primeiroPonto = new SimpleDoubleProperty(primeiroPonto);
        this.segundoPonto = new SimpleDoubleProperty(segundoPonto); 
    }
    
    /**
    public void inserirLevantamento(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO levantamento(Edif_num,Edif_nome,Edif,Edfi_lat,Edif_long)"
        } catch (Exception e) {
        }
    }
    */
}
