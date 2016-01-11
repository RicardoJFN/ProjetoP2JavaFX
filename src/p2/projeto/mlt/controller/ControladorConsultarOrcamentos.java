/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Orcamento;

/**
 *
 * @author 
 */
public class ControladorConsultarOrcamentos {

    @FXML
    private javafx.scene.control.Button sair;
    @FXML
    private TableView<Orcamento> tabelaOrcamento;
    @FXML
    private TableColumn<Orcamento, String> numero;
    @FXML
    private TableColumn<Orcamento, String> data;

    private ObservableList<Orcamento> orcamentos = FXCollections.observableArrayList();

    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage consultaOrcamentos = (Stage) sair.getScene().getWindow();
            consultaOrcamentos.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/MenuPrincipal.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Principal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        tabelaOrcamento.setEditable(true);
        orcamentos = FXCollections.observableArrayList(Orcamento.selecionaOrcamentos());
        numero.setCellValueFactory(cellData -> cellData.getValue().getIdOrcamento().asString());
        data.setCellValueFactory(cellData -> cellData.getValue().getDataOrcamento().asString());
        tabelaOrcamento.setItems(orcamentos);
    }

}
