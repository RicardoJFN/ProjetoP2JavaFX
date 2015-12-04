/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Edificio;

/**
 *
 * @author ricardon
 */
public class ControladorMedirEdificio {
 
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
    
    private Stage medirEdificio;
    private Edificio edificio;
    
    /**
    public void setNovaMedicaoEdf(Stage medirEdificio){
        this.medirEdificio = medirEdificio;
    }
    * */
    
    /**
    public void inserirEdificioBD(){
        Edificio edificio = new Edificio(Double.parseDouble(primeiroPontoLat.getText()), Double.parseDouble(primeiroPontoLong.getText()),
                Double.parseDouble(segundoPontoLat.getText()), Double.parseDouble(segundoPontoLong.getText()), 
                Double.parseDouble(terceiroPontoLat.getText()), Double.parseDouble(terceiroPontoLong.getText()),
                Double.parseDouble(quartoPontoLat.getText()), Double.parseDouble(quartoPontoLong.getText()));
        edificio.inserirEdificio();
        
       
    }
    * */
    
    
    @FXML
    public void mostraJanelaNovoEquipamento(){
         try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/IdentificacaoEquipamento.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Novo Equipamento");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
          e.printStackTrace();
      }
      
    }
}
