/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ricardon
 */
public class Cliente {
    
    
    /**
     * Definição de atributos da classe Cliente
     */
    
    protected StringProperty nome;
    protected StringProperty morada;
    protected IntegerProperty codigoPostal;
    protected StringProperty localidade;
    protected StringProperty pais;
    protected IntegerProperty contactoTelefone;
    protected IntegerProperty contactoTelemovel;
    protected IntegerProperty contactoEmail;
    
    /**
     * Construtor da classe Cliente FALTA ACABAR
     * @param nome
     * @param morada
     */
    
    public Cliente(String nome, String morada, int codigoPostal, String localidade, String pais, int contactoTelefone,
            int contactoTelemovel, int contactoEmail){
        
        this.nome = new SimpleStringProperty(nome);
        this.morada = new SimpleStringProperty(morada);
        this.codigoPostal = new SimpleIntegerProperty(codigoPostal);
        this.localidade = new SimpleStringProperty(localidade);
        this.pais = new SimpleStringProperty(pais);
        this.contactoTelefone = new SimpleIntegerProperty(contactoTelefone);
        this.contactoTelemovel = new SimpleIntegerProperty(contactoTelemovel);
        this.contactoEmail = new SimpleIntegerProperty(contactoEmail);
    }
    
}
