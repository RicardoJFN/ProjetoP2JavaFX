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

/**
 *
 * @author ricardon
 */
public class Levantamento {
    
    //Definição de atributos da classe Levantamento
    protected IntegerProperty numero;
    protected ObjectProperty<LocalDate> data;
    protected DoubleProperty primeiroPonto;
    protected DoubleProperty segundoPonto;
    protected DoubleProperty terceiroPonto;
    protected DoubleProperty quartoPonto;
    
    
    /**
     * Construtor da classe Levantamento 
     * @param numero
     * @param data
     * @param primeiroPonto
     * @param segundoPonto
     * @param terceiroPonto
     * @param quartoPonto
     */
    
    public Levantamento(int numero, LocalDate data, double primeiroPonto, double segundoPonto, double terceiroPonto, double quartoPonto){
        this.numero = new SimpleIntegerProperty(numero);
        this.data = new SimpleObjectProperty<>(data);
        this.primeiroPonto = new SimpleDoubleProperty(primeiroPonto);
        this.segundoPonto = new SimpleDoubleProperty(segundoPonto);
        this.terceiroPonto = new SimpleDoubleProperty(terceiroPonto);
        this.quartoPonto = new SimpleDoubleProperty(quartoPonto);
    }
}
