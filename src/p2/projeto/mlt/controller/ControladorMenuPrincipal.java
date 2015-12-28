/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;


import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ricardon
 */
public class ControladorMenuPrincipal {
    
	@SuppressWarnings("unused")
	private MainApp mainApp;
	
	@SuppressWarnings("unused")
	private Stage menuPrincipal;
	
	
	public void setMainApp(MainApp mainApp){
		this.mainApp = mainApp;
	}
	
	
	public void setMenuPrincipal(Stage menuPrincipal){
		this.menuPrincipal = menuPrincipal;
	}
	
	@FXML
	private void mostraNovoLevantamento(){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/views/CriarNovoLevantamento.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Novo Levantamento");
			stage.setScene(new Scene(root));
			stage.show();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
    
}
