/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ricardon
 */
public class Equipamento {
    
    /**
     * Definição de atributos da classe Equipamento;
     */
    protected StringProperty tipo;
    protected StringProperty subTipo;
    protected StringProperty marca;
    protected StringProperty modelo;
    protected Estado estadoEquipamento;
    protected StringProperty detalhes;
    
    
    /**
     * Construtor da classe Cliente 
     * @param tipo
     * @param subTipo
     * @param marca
     * @param modelo
     * @param estadoEquipamento
     * @param detalhes
     */
    
    public Equipamento(String tipo, String subTipo, String marca, String modelo, Estado estadoEquipamento, String detalhes){
        this.tipo = new SimpleStringProperty(tipo);
        this.subTipo = new SimpleStringProperty(subTipo);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.estadoEquipamento = estadoEquipamento;
        this.detalhes = new SimpleStringProperty(detalhes);
    }
    
    //Enumeração Estado que servirá para determinar o estado do equipamento a orçamentar
    public enum Estado {EXCELENTE, RAZOAVEL, DEGRADADO};
    
}
