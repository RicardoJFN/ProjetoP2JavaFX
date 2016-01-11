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
 * @author 
 */
public class ControladorDetalheCliente {

    @FXML
    private javafx.scene.control.Button sair;

    /**
     * Metodo para botao Sair - Botao para sair da janela
     */
    @FXML
    private void botaoSair() {
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.hide();
    }

    @FXML
    public void mostraJanelaNovoCliente() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoCliente.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Cliente");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
