/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author ricardon
 */
public class NovoTipoEquipamento {
    
    protected StringProperty tipo;
    protected StringProperty subTipo;
    protected DoubleProperty valorTipo;
    
    
    
    public NovoTipoEquipamento(String tipo, String subTipo, double valorTipo){
        this.tipo = new SimpleStringProperty(tipo);
        this.subTipo = new SimpleStringProperty(subTipo);
        this.valorTipo = new SimpleDoubleProperty(valorTipo);
    }

    public NovoTipoEquipamento() {
        
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

    public DoubleProperty getValorTipo() {
        return valorTipo;
    }

    public void setValorTipo(DoubleProperty valorTipo) {
        this.valorTipo = valorTipo;
    }

    
    public void inserirTipoEquipamento(NovoTipoEquipamento novoTipo) {
        try {
            //Falta fazer a tabela na base de dados e terminar a linha de código abaixo feita.
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO tipoequipamento(tipo,sub_tipo,valor) VALUES (?,?,?)";
            Connection conectar = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conectar.prepareStatement(insertStatement);
            
            ps.setString(1, novoTipo.tipo.getValue());
            ps.setString(2, novoTipo.subTipo.getValue());
            ps.setString(3, Double.toString(valorTipo.getValue()));
            
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
   
    public String selecionaTipoEquipamento(){
        
        String tipo = "";
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            Statement stmt = con.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT tipo FROM TipoEquipamento");
            
            int maxID = 0;
            
            while(rs.next()){
                tipo = rs.getString("tipo");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return tipo;
    }
    
    public String selecionaSubTipoEquipamento(){
        
        String subTipo = "";
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            Statement stmt = con.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELEC subTipo FROM TipoQuipamento");
            
            int maxID = 0;
            
            while(rs.next()){
                subTipo = rs.getString("subTipo");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        return subTipo;
    }
    
    
    
}
