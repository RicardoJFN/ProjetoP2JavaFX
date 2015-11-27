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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    public void mostraJanelaNovoCliente(){
         try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/NovoCliente.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Novo Cliente");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
    }
    
    
    @FXML
    public void sair(){
        
        janelaLevantamento = true;
        novoLevantamento.close();
    }
    
    
    
}
