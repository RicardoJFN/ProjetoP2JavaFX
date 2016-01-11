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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.Edificio;
import p2.projeto.mlt.model.Equipamento;
import p2.projeto.mlt.model.Levantamento;
import p2.projeto.mlt.model.Orcamento;

/**
 *
 * @author 
 */
public class ControladorNovoOrcamento {

    @FXML
    private TextField dataOrcamento;
    @FXML
    private ComboBox<Cliente> cliente;
    @FXML
    private ComboBox<Edificio> edificio;
    @FXML
    private ComboBox<Levantamento> levantamento;
    @FXML
    private ComboBox<Double> valorOrc;
    @FXML
    private javafx.scene.control.Button voltar;
    @FXML
    private javafx.scene.control.Button sair;
    
    private Stage novoOrcamento;
    private boolean janelaOrcamento = false;

    @FXML
    private void initialize() {
        cliente.getItems().addAll(Cliente.selecionaCliente());
        edificio.getItems().addAll(Edificio.selecionaEdificio());
        levantamento.getItems().addAll(Levantamento.selecionaLevantamento());
        valorOrc.getItems().addAll(Equipamento.selecionaValorEquipamento());
    }

    public void setNovoOrcamento() {
        this.novoOrcamento = novoOrcamento;
    }

    public boolean isJanelaOrcamento() {
        return janelaOrcamento;
    }

    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage criarNovoOrcamento = (Stage) voltar.getScene().getWindow();
            criarNovoOrcamento.close();
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

    @FXML
    public void mostraResumoLevantamento() {
        try {
            Stage criarNovoOrcamento = (Stage) sair.getScene().getWindow();
            criarNovoOrcamento.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ResumoOrcamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Resumo levantamento");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void guardarInfo() {
        try {
            Orcamento novoOrcamento = new Orcamento(Integer.parseInt(dataOrcamento.getText()), edificio.getValue(), cliente.getValue(), levantamento.getValue(),
                    valorOrc.getValue());
            novoOrcamento.inserirNovoOrcamento();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
