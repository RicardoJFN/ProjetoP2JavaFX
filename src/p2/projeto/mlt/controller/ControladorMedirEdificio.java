/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Edificio;

/**
 *
 * @author ricardon
 */
public class ControladorMedirEdificio {
 
    @FXML
    private TextField primeiroPontoTF;
    @FXML
    private TextField segundoPontoTF;
    @FXML
    private TextField terceiroPontoTF;
    @FXML
    private TextField quartoPontoTF;
    
    private Stage medirEdificio;
    private Edificio edificio;
    
    public void setNovaMedicaoEdf(Stage medirEdificio){
        this.medirEdificio = medirEdificio;
    }
    
    
    public void inserirEdificioBD(){
        Edificio edificio = new Edificio(Double.parseDouble(primeiroPontoTF.getText()), Double.parseDouble(segundoPontoTF.getText()), 
                Double.parseDouble(terceiroPontoTF.getText()), Double.parseDouble(quartoPontoTF.getText()));
        edificio.inserirEdificio();
    }
}
