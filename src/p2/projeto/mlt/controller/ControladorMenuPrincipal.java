/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author ricardon
 */
public class ControladorMenuPrincipal {
    
    
    
    private Stage menuPrincipal;
    
  @FXML
  private void initialize(){
      
  }
  
  public void setMenuPrincipal(Stage menuPrincipal){
      this.menuPrincipal = menuPrincipal;
  }
    
  @FXML
  public void sair(){
      
      menuPrincipal.close();
  }
  
}
