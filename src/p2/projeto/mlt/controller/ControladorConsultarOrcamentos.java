/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import p2.projeto.mlt.model.Orcamento;

/**
 *
 * @author carlosb
 */
public class ControladorConsultarOrcamentos {
    @FXML
    private TableView<Orcamento> tabelaOrcamento;
    @FXML
    private TableColumn<Orcamento, String> numero;
    @FXML
    private TableColumn<Orcamento, String> data;
    
    private ObservableList<Orcamento> orcamentos = FXCollections.observableArrayList();
    
    @FXML
    private void initialize(){
        tabelaOrcamento.setEditable(true);
        orcamentos = FXCollections.observableArrayList(Orcamento.selecionaOrcamentos());
        numero.setCellValueFactory(cellData -> cellData.getValue().getIdOrcamento().asString());
        data.setCellValueFactory(cellData -> cellData.getValue().getDataOrcamento().asString());
        tabelaOrcamento.setItems(orcamentos);
    }
}
