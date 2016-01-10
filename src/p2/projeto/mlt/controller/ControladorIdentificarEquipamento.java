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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Edificio;
import p2.projeto.mlt.model.Equipamento;

/**
 *
 * @author ricardon
 */
public class ControladorIdentificarEquipamento {

    /**
     * Nome da Ligacao ao botao - colocado no fx:id do botao sair
     */
    @FXML
    private javafx.scene.control.Button voltar;
    @FXML
    private javafx.scene.control.Button sair;
    @FXML
    private TableView<Equipamento> tabelaEquipamentos;
    @FXML
    private TableColumn<Equipamento, String> tipo;

    private ObservableList<Equipamento> equipamentos = FXCollections.observableArrayList();

    public ObservableList<Equipamento> getClienteData() {
        return equipamentos;
    }

    @FXML
    private void initialize() {

        equipamentos = FXCollections.observableArrayList(Equipamento.selecionaEquipamentos());
        tipo.setCellValueFactory(cellData -> cellData.getValue().getTipoEquip());
        tabelaEquipamentos.setItems(equipamentos);
    }

    @FXML
    public void voltarNovoLevantamento() {
        try {
            Stage identificarEquipamentos = (Stage) voltar.getScene().getWindow();
            identificarEquipamentos.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoLevantamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MenuPrincipal");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para botao Adicionar Equipamento presente na janela identificar
     * equipamentos - botão de passagem para view AdicionarNovoEquipamento que
     * vai permitir adicionar equipamentos ao levantamento e colocar na janela
     * de equipamentos
     */
    @FXML
    public void mostraAdicionarEquipamento() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/AdicionarNovoEquipamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Equipamento");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para botao seguinte presente na janela IdentificarEquipamentos -
     * botao de passagem para view resumoLevantamento que vai permitir ver o
     * resumo de todo o levantamento
     */
    @FXML
    private void mostraResumoLevantamento() {

        try {
            Stage identificarEquipamentos = (Stage) sair.getScene().getWindow();
            identificarEquipamentos.hide();
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
