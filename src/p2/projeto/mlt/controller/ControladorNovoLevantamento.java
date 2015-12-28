/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;


import java.io.File;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.Edificio;
import p2.projeto.mlt.model.Levantamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoLevantamento {
    
	@FXML
	private TextField numeroLevantamento;
	@FXML
	private TextField dataLevantamento;
	@FXML
	private ComboBox<Cliente> nomeCliente;
	@FXML
	private ComboBox<Edificio> nomeEdificio;
	@FXML
	private TextField primeiroPontoLat;
	@FXML
	private TextField primeiroPontoLong;
	@FXML
	private TextField segundoPontoLat;
	@FXML
	private TextField segundoPontoLong;
	@FXML
	private TextField terceiroPontoLat;
	@FXML
	private TextField terceiroPontoLong;
	@FXML
	private TextField quartoPontoLat;
	@FXML
	private TextField quartoPontoLong;
	@FXML
	private TextField areaTotal;
	
	private Stage novoLevantamento;
	private boolean janelaLevantamento = false;
	
	
	@FXML
	private void initialize(){
		
		
		nomeCliente.onActionProperty().addListener((obs, oldvalue, newvalue) ->{
			nomeCliente.getItems().addAll(Cliente.selecionaNomesCliente());
		});
		
		nomeEdificio.onActionProperty().addListener((obs, oldvalue, newvalue)->{
			nomeEdificio.getItems().addAll(Edificio.selecionaNomesEdificio());
		});
		
		
		
	}
	
	
	public void setNovoLevantamento(Stage novoLevantamento){
		this.novoLevantamento = novoLevantamento;
	}
	
	public boolean isJanelaLevantamento(){
		return janelaLevantamento;
	}
	
	@FXML
	public void mostraJanelaNovoCliente(){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/views/CriarNovoCliente.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Novo Cliente");
			stage.setScene(new Scene(root));
			stage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void mostraJanelaNovoEdificio(){
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/views/CriarNovoEdificio.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Novo Edificio");
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void mostraJanelaIdentificarEquipamentos(){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/views/IdentificarEquipamentos.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Identificacao de Equipamentos");
			stage.setScene(new Scene(root));
			stage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public void guardarInfo(){
		Levantamento novoLevantamento = new Levantamento(Integer.parseInt(numeroLevantamento.getText()), Integer.parseInt(dataLevantamento.getText()),
				nomeCliente.getValue(),  nomeEdificio.getValue(), Double.parseDouble(primeiroPontoLat.getText()), Double.parseDouble(primeiroPontoLong.getText()),
				Double.parseDouble(segundoPontoLat.getText()), Double.parseDouble(segundoPontoLong.getText()), Double.parseDouble(terceiroPontoLat.getText()),
				Double.parseDouble(terceiroPontoLong.getText()), Double.parseDouble(quartoPontoLat.getText()), Double.parseDouble(quartoPontoLong.getText()));
		novoLevantamento.inserirNovoLevantamento(novoLevantamento);
	}
}
