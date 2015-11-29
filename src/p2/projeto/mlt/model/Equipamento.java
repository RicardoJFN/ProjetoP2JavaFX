/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ricardon
 */
public class Equipamento {
    
    protected ArrayList<NovoTipoEquipamento> novoTipoEquipamento;
    
    
    /**
     * Definição de atributos da classe Equipamento;
     */
    
    
    protected StringProperty tipo;
    protected StringProperty subTipo;
    protected StringProperty marca;
    protected StringProperty modelo;
    protected StringProperty numeroSerie;
    protected Estado estadoEquipamento;
    protected StringProperty detalhes;
    
    
    
    /**
     * Construtor da classe Cliente 
     * @param tipo
     * @param subTipo
     * @param marca
     * @param modelo
     * @param numeroSerie
     * @param estadoEquipamento
     * @param detalhes
     */
    
    public Equipamento(String marca, String modelo, String numeroSerie, Estado estadoEquipamento, String detalhes){
        
        for(int i = 0; i < novoTipoEquipamento.size(); i++){
            this.tipo = new SimpleStringProperty(novoTipoEquipamento.get(i).selecionaTipoEquipamento());
            this.subTipo = novoTipoEquipamento.get(i).getSubTipo();
        }
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.numeroSerie = new SimpleStringProperty(numeroSerie);
        this.estadoEquipamento = estadoEquipamento;
        this.detalhes = new SimpleStringProperty(detalhes);
    }
    
    //Enumeração Estado que servirá para determinar o estado do equipamento a orçamentar
    public enum Estado {EXCELENTE, RAZOAVEL, DEGRADADO};
    
}
