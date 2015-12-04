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
import javafx.stage.Stage;

/**
 *
 * @author ricardon
 */
public class ControladorIdentEquipamento {
    
    @FXML
    public void mostraJanelaAdicionarEquipamento(){
        try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/AdicionarEquipamento.fxml"));
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
