/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

/**
 *
 * @author ricardon
 */
public class Cliente {
    
    
    /**
     * Definição de atributos da classe Cliente
     */
    
    protected String nome;
    protected String morada;
    protected int codigoPostal;
    protected String localidade;
    protected String pais;
    protected int contactoTelefone;
    protected int contactoTelemovel;
    protected int contactoEmail;
    
    /**
     * Construtor da classe Cliente FALTA ACABAR
     * @param nome
     * @param morada
     */
    
    public Cliente(String nome, String morada, int codigoPostal, String localidade, String pais, int contactoTelefone,
            int contactoTelemovel, int contactoEmail){
        
        this.nome = nome;
        this.morada = morada;
        this.codigoPostal = codigoPostal;
        this.localidade = localidade;
        this.pais = pais;
        this.contactoTelefone = contactoTelefone;
        this.contactoTelemovel = contactoTelemovel;
        this.contactoEmail = contactoEmail;
    }
    
}
