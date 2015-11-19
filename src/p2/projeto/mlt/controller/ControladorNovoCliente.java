/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    
   
    
}
