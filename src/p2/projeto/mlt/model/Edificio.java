/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ricardon
 */
public class Edificio {
    
    //Definição de atributos da classe Edificio
    protected StringProperty nome;
    protected DoubleProperty coordLatitude;
    protected DoubleProperty coordLongitude;
    protected IntegerProperty numero;
   
    
    /**
     * Construtor da classe Cliente 
     * @param nome
     * @param coordLatitude
     * @param coordLongitude
     * @param numero
     */
    public Edificio(String nome, double coordLatitude, double coordLongitude, int numero){
        this.nome = new SimpleStringProperty(nome);
        this.coordLatitude = new SimpleDoubleProperty(coordLatitude);
        this.coordLongitude = new SimpleDoubleProperty(coordLongitude);
        this.numero = new SimpleIntegerProperty(numero);
    }
}
