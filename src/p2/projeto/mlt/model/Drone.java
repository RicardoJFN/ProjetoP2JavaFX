/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author ricardon
 */
public class Drone {
    
    //Definição de atributos da classe Drone
    protected BooleanProperty ligar;
    
    
    /**
     * Construtor da classe Drone 
     * @param ligar
     */
    
    public Drone(boolean ligar){
        this.ligar = new SimpleBooleanProperty(ligar);
    }
}
