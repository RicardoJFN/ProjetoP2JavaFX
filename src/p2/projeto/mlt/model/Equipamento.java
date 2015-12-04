/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author ricardon
 */
public class Equipamento {
    
    protected ArrayList<NovoTipoEquipamento> novoTipoEquipamento;
    
    
    /**
     * Definição de atributos da classe Equipamento;
     */
    
    protected IntegerProperty equipamentoID;
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
    
    public Equipamento(String tipo, String subTipo, String marca, String modelo, String numeroSerie, Estado estadoEquipamento, String detalhes){
        
        this.tipo = new SimpleStringProperty(tipo);
        this.subTipo = new SimpleStringProperty(subTipo);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.numeroSerie = new SimpleStringProperty(numeroSerie);
        this.estadoEquipamento = estadoEquipamento;
        this.detalhes = new SimpleStringProperty(detalhes);
    }
    
    public Equipamento(int equipamentoID,String tipo, String subTipo, String marca, String modelo, String numeroSerie, Estado estadoEquipamento, String detalhes){
        
        this.equipamentoID = new SimpleIntegerProperty(equipamentoID);
        this.tipo = new SimpleStringProperty(tipo);
        this.subTipo = new SimpleStringProperty(subTipo);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.numeroSerie = new SimpleStringProperty(numeroSerie);
        this.estadoEquipamento = estadoEquipamento;
        this.detalhes = new SimpleStringProperty(detalhes);
    }
    
    //Enumeração Estado que servirá para determinar o estado do equipamento a orçamentar
    public enum Estado {EXCELENTE, RAZOAVEL, DEGRADADO};

    public IntegerProperty getEquipamentoID() {
        return equipamentoID;
    }

    public void setEquipamentoID(IntegerProperty equipamentoID) {
        this.equipamentoID = equipamentoID;
    }
    
    public StringProperty getTipo() {
        return tipo;
    }

    public void setTipo(StringProperty tipo) {
        this.tipo = tipo;
    }

    public StringProperty getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(StringProperty subTipo) {
        this.subTipo = subTipo;
    }

    public StringProperty getMarca() {
        return marca;
    }

    public void setMarca(StringProperty marca) {
        this.marca = marca;
    }

    public StringProperty getModelo() {
        return modelo;
    }

    public void setModelo(StringProperty modelo) {
        this.modelo = modelo;
    }

    public StringProperty getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(StringProperty numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Estado getEstadoEquipamento() {
        return estadoEquipamento;
    }

    public void setEstadoEquipamento(Estado estadoEquipamento) {
        this.estadoEquipamento = estadoEquipamento;
    }

    public StringProperty getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(StringProperty detalhes) {
        this.detalhes = detalhes;
    }
    
    public void inserirEquipamento(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO equipamento(Equip_marca,Equip_model,Equip_desc,Equip_serie,Equip_tipo,Equip_sbtipo,Equip_estado) VALUES(?,?,?,?,?,?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setString(1, marca.getValue());
            ps.setString(2, modelo.getValue());
            ps.setString(3, detalhes.getValue());
            ps.setString(4, numeroSerie.getValue());
            ps.setString(5, tipo.getValue());
            ps.setString(6, subTipo.getValue());
            //Alterar esta linha
            ps.setString(7, estadoEquipamento.name());
        } catch (Exception e) {
        }
    }
    
}
