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
 * @author carlosb
 */
public class ControladorNovoTipoEquipamento {
    
        /**
     * Nome da Ligacao ao botao - colocado no fx:id do botao sair
     */
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
    
    
}
