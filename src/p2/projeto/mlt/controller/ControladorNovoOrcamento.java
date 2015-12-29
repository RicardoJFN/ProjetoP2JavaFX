package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carlosb
 */
public class ControladorNovoOrcamento {
    
    
     /**
     * Metodo para botao ver levantamento presente na janela CriarNovoOrcamento -
     * botao para view resumoLevantamento que vai permitir ver o
     * resumo do levantamento seleccionado
     */
    @FXML
    private void mostraResumoLevantamento() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ResumoLevantamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Resumo levantamento");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }

    }
    
}
