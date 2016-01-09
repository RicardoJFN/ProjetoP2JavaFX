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
    
    /**
     * 
     * Metodo que o botao guardar utiliza " on action " para executar o codigo a partir da class modelo Cliente
     * 
     */
    
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
    
   
    

