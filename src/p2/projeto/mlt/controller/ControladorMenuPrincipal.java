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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 *
 *
 */
public class ControladorMenuPrincipal {

    private MainApp mainApp;
    private Stage menuPrincipal;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setMenuPrincipal(Stage menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
    /**
     * Nome da Ligacao ao botao - colocado no fx:id do botao sair
     */
    @FXML
    private javafx.scene.control.Button sair;

    /**
     * Metodo para botao Sair - Botao para sair do programa
     */
    @FXML
    private void botaoSair() {
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.hide();
    }

    /**
     * Metodo mostra novo levantamento
     *
     */
    @FXML
    private void mostraNovoLevantamento() {
        try {

            Stage MenuPrincipal = (Stage) sair.getScene().getWindow();
            MenuPrincipal.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoLevantamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Levantamento");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para botao Elaborar Orcamento presente no menu principal - botão
     * de passagem para view CriacaoOrcamento
     */
    @FXML
    private void mostraCriarOrcamento() {
        try {
            Stage MenuPrincipal = (Stage) sair.getScene().getWindow();
            MenuPrincipal.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoOrcamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Orçamento");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para botao Consultar levantamentos Efetuados presente no menu
     * principal - botão de passagem para view ConsultarLevantamentos
     */
    @FXML
    private void mostraLevantamentosEfetuados() {

        try {
            Stage MenuPrincipal = (Stage) sair.getScene().getWindow();
            MenuPrincipal.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultarLevantamentos.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Consulta de Levantamentos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }

    }

    /**
     * Metodo para botao Consultar Clientes presente no menu principal - botão
     * de passagem para view ConsultarClientes
     */
    @FXML
    private void mostraConsultarClientes() {

        try {
            Stage MenuPrincipal = (Stage) sair.getScene().getWindow();
            MenuPrincipal.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultarClientes.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Consulta Clientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }
    }

    /**
     * Metodo para botao Consultar Orcamentos presente no menu principal - botão
     * de passagem para view ConsultaOrcamentos
     */
    @FXML
    private void mostraConsultarOrcamentos() {

        try {
            Stage MenuPrincipal = (Stage) sair.getScene().getWindow();
            MenuPrincipal.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultarOrcamentos.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Consulta Orçamentos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }

    }

    @FXML
    private void ligarDesligar() {

        //ProgressIndicator pi = new ProgressIndicator();
        ProgressBar pb = new ProgressBar();
        pb.setProgress(0.45);

    }

}
