/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 *
 * @author ricardon
 */
public class ControladorNovoLevantamento {
    
    private Stage novoLevantamento;
    private boolean janelaLevantamento = false;
    
    
    @FXML
    private void initialize(){
        
    }
    
    public void setNovoLevantamento(Stage novoLevantamento){
        this.novoLevantamento = novoLevantamento;
    }
    
    public boolean isJanelaLevantamento(){
        return janelaLevantamento;
    } 
    
    
    @FXML
    public void sair(){
        
        janelaLevantamento = true;
        novoLevantamento.close();
    }
    
    
    
}
