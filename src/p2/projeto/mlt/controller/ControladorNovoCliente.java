/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import p2.projeto.mlt.model.IMetodosBD;
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

/**
 *
 * @author ricardon
 */
public class ControladorNovoCliente {
    
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField moradaCliente;
    @FXML
    private TextField postalCliente;
    @FXML
    private TextField localidadeCliente;
    @FXML
    private TextField paisCliente;
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

    @FXML
    public void executar() {
        
        Cliente novoCliente = new Cliente(nomeCliente.getText(), moradaCliente.getText(), Integer.parseInt(postalCliente.getText()), 
                Integer.parseInt(telefoneCliente.getText()), Integer.parseInt(telemovelCliente.getText()), 
                emailCliente.getText(), localidadeCliente.getText());
        novoCliente.inserirNovoCliente(novoCliente);
    
    }

    }
    
   
    

