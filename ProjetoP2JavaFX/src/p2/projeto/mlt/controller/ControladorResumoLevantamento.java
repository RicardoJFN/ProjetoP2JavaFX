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
 * @author carlosb
 */
public class ControladorResumoLevantamento {
 
     @FXML
 private javafx.scene.control.Button sair;
    
    /**
     * Metodo para botao Voltar que vai permitir voltar a janela anterior
     */ 
     
    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage resumoLevantamento = (Stage) sair.getScene().getWindow();
            resumoLevantamento.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/MenuPrincipal.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
