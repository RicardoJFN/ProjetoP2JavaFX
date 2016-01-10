/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.Edificio;

public class ControladorNovoEdificio {

    @FXML
    private ComboBox<Cliente> nomeCliente;
    @FXML
    private TextField numeroEdificio;
    @FXML
    private TextField nomeEdificio;
    @FXML
    private TextField latEdificio;
    @FXML
    private TextField longEdificio;

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

    @FXML
    private void initialize() {
        nomeCliente.getItems().addAll(Cliente.selecionaCliente());
    }

    @FXML
    private void guardarInfo() {

        try {
            Edificio novoEdificio = new Edificio(nomeCliente.getValue(), Integer.parseInt(numeroEdificio.getText()), nomeEdificio.getText(), Double.parseDouble(latEdificio.getText()), Double.parseDouble(longEdificio.getText()));
            novoEdificio.inserirNovoEdificio();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
