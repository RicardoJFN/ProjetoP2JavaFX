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
	private TextField telefoneCliente;
	@FXML
	private TextField telemovelCliente;
	@FXML
	private TextField emailCliente;
	

            /**
     * Nome da Ligacao ao botao - colocado no fx:id do botao sair
     */
        @FXML
        private javafx.scene.control.Button sair;

    /**
     * Metodo para botao Sair - Botao para sair da janela
     */
    @FXML
    private void botaoSair() {
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.hide();
    }
        
	@FXML
	public void guardarInfo(){
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		Cliente novoCliente = new Cliente(nomeCliente.getText(), moradaCliente.getText(), 
				Double.parseDouble(postalCliente.getText()), 
				Integer.parseInt(telefoneCliente.getText()), Integer.parseInt(telemovelCliente.getText()), 
				emailCliente.getText());
		
		novoCliente.inserirNovoCliente(novoCliente);
	}


  }
    
   
    

