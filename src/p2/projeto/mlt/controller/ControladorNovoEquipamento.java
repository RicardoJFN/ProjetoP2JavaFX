/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import p2.projeto.mlt.model.Equipamento;
import p2.projeto.mlt.model.NovoTipoEquipamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoEquipamento {
    
    @FXML
    private ComboBox<String> tipoEquipamento;
    @FXML
    private ComboBox<NovoTipoEquipamento> subTipoEquipamento;
    @FXML
    private TextField marca;
    @FXML
    private TextField modelo;
    @FXML
    private TextField numeroSerie;
    @FXML
    private ComboBox<Enum> estadoEquipamento;
    @FXML
    private TextField detalhesEquipamento;
    
    
    
    @FXML
    private void initialize(){
        estadoEquipamento.getItems().addAll(Equipamento.Estado.values());
        tipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaNomesTiposEquipamento());
        tipoEquipamento.onActionProperty().addListener((obs,oldvalue,newvalue) -> {
            String nome = tipoEquipamento.getSelectionModel().getSelectedItem();
            subTipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaSubTiposEquipamento(nome));
        });
    }
    
    
    @FXML
    public void executar(){
        //Equipamento novoEquipamento = new Equipamento(tipoEquipamento.getValue(), subTipoEquipamento.getValue(), marca.getText(), modelo.getText(), numeroSerie.getText(), estadoEquipamento.getValue(), detalhesEquipamento.getText());
    }
}
