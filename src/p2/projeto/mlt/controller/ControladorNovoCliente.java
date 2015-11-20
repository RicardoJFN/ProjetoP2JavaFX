/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.DAL.ConexaoBaseDados;
import static p2.projeto.mlt.DAL.ConexaoBaseDados.conectar;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.IMetodosBD;

/**
 *
 * @author ricardon
 */
public class ControladorNovoCliente implements IMetodosBD{
    
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField moradaCliente;
    @FXML
    private TextField postalCliente;
    @FXML
    private TextField localidadeCliente;
    @FXML
    private TextField telefoneCliente;
    @FXML
    private TextField telemovelCliente;
    @FXML
    private TextField emailCliente;
    
    private Stage novoCliente;
    private Cliente cliente;
    
    
    
    @FXML
    private void initialize(){
        
    }
    
    public void setNovoCliente(Stage novoCliente){
        this.novoCliente = novoCliente;
    }

    @Override
    public void inserir() {
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String queryString = "INSERT INTO cliente VALUES (?,?,?,?,?,?,?)";
            Connection conectar = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conectar.prepareStatement(queryString);
            
            ps.setString(1, nomeCliente.getText());
            ps.setString(2, moradaCliente.getText());
            ps.setString(3, postalCliente.getText());
            ps.setString(4, localidadeCliente.getText());
            ps.setString(5, telefoneCliente.getText());
            ps.setString(6, telemovelCliente.getText());
            ps.setString(7, emailCliente.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        
    }
    
   
    

