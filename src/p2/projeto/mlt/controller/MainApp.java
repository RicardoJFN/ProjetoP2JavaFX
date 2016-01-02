/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.Edificio;
import p2.projeto.mlt.model.Equipamento;
import p2.projeto.mlt.model.Levantamento;

/**
 *
 * @author ricardon
 */
public class MainApp extends Application{
    
	private Stage primaryStage;
	
	@Override
	public void start(Stage primeryStage){
		this.primaryStage = new Stage();
		this.primaryStage.setTitle("Menu Principal");
		
		menuPrincipal();
	}

	public void menuPrincipal(){
		try{
                    
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/p2/projeto/mlt/view/MenuPrincipal.fxml"));
			
			AnchorPane layout = (AnchorPane) loader.load();
			Scene scene = new Scene(layout);
			primaryStage.setScene(scene);
			primaryStage.show();
                       
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public static void main(String[] args){
		launch(args);
	}
}
