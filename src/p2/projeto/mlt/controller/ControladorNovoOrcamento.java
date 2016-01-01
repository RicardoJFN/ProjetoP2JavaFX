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
import p2.projeto.mlt.model.Levantamento;
import p2.projeto.mlt.model.Orcamento;

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
    
    
    @FXML
    private TextField dataOrcamento;
    @FXML
    private ComboBox<Cliente> cliente;
    @FXML
    private ComboBox<Edificio> edificio;
    @FXML
    private ComboBox<Levantamento> levantamento;
    
    
    @FXML
    private void initialize(){
        cliente.getItems().addAll(Cliente.selecionaCliente());
        edificio.getItems().addAll(Edificio.selecionaEdificio());
        levantamento.getItems().addAll(Levantamento.selecionaLevantamento());
    }
    
    
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
            e.printStackTrace();
        }

    }
    
    @FXML
    public void guardarInfo(){
        
        Orcamento novoOrcamento = new Orcamento(Integer.parseInt(dataOrcamento.getText()));
        /*
        try {
            Orcamento novoOrcamento = new Orcamento(Integer.parseInt(dataOrcamento.getText()), edificio.getValue(), cliente.getValue(),
                        levantamento.getValue());
            novoOrcamento.inserirOrcamento();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
    
    
}
