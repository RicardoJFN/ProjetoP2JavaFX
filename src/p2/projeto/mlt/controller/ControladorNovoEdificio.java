/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.Edificio;

public class ControladorNovoEdificio {
	
	@FXML
	private ComboBox<Cliente> nomeCliente;
	@FXML
	private TextField numeroEdificio;
	@FXML
	private TextField nomeEdificio;
	@FXML
	private TextField latEdificio;
	@FXML
	private TextField longEdificio;
	
	@FXML
	private void initialize(){
            
            
           
            nomeCliente.getItems().addAll(Cliente.selecionaCliente());
            
	}
	
	@FXML
	private void guardarInfo(){
		
            try {
                Edificio novoEdificio = new Edificio(nomeCliente.getValue(), Integer.parseInt(numeroEdificio.getText()), nomeEdificio.getText(), Double.parseDouble(latEdificio.getText()), Double.parseDouble(longEdificio.getText()));
                novoEdificio.inserirNovoEdificio();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
	}

}
