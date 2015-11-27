/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    public NovoTipoEquipamento(String tipo, String subTipo){
        this.tipo = new SimpleStringProperty(tipo);
        this.subTipo = new SimpleStringProperty(subTipo);
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

    public void inserirTipoEquipamento(NovoTipoEquipamento novoTipo) {
        try {
            //Falta fazer a tabela na base de dados e terminar a linha de código abaixo feita.
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO () VALUES (?,?)";
            Connection conectar = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conectar.prepareStatement(insertStatement);
            
            ps.setString(1, novoTipo.tipo.getValue());
            ps.setString(2, novoTipo.subTipo.getValue());
            
            ps.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
