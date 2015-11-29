/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

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
    private ComboBox<String> subTipoEquipamento;
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
    
    private NovoTipoEquipamento teste = new NovoTipoEquipamento();
    
    @FXML
    private void initialize(){
        estadoEquipamento.getItems().addAll(Equipamento.Estado.values());
        tipoEquipamento.getItems().addAll(teste.selecionaTipoEquipamento());
        subTipoEquipamento.getItems().addAll(teste.selecionaSubTipoEquipamento());
    }
    
}
