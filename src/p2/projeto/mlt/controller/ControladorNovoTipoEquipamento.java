/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.DAL.ConexaoBaseDados;
import p2.projeto.mlt.model.IMetodosBD;
import p2.projeto.mlt.model.NovoTipoEquipamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoTipoEquipamento implements IMetodosBD{
    
    @FXML
    private TextField tipoEquipamento;
    @FXML
    private TextField subTipoEquipamento;
    
    private Stage novoTipoEquipamento;
    private NovoTipoEquipamento novoTipo;
    
    @FXML
    private void initialize(){
        
    }
    
    public void setNovoTipoEquipamento(Stage novoTipoEquipamento){
        this.novoTipoEquipamento = novoTipoEquipamento;
    }
    
    @Override
    public void inserir(){
        try {
            //Terminar a tabela da base dados com esta informação.
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String queryString = "INSERT INTO () VALUES (?,?)";
            Connection conectar = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conectar.prepareStatement(queryString);
            
            ps.setString(1, tipoEquipamento.getText());
            ps.setString(2, subTipoEquipamento.getText());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
