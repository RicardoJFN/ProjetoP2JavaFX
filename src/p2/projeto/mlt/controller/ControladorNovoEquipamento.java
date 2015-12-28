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
import p2.projeto.mlt.model.Equipamento.Estado;
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
	private TextField marcaEquipamento;
	@FXML
	private TextField modeloEquipamento;
	@FXML
	private TextField numeroSerieEquipamento;
	@FXML
	private ComboBox<Estado> estadoEquipamento;
	@FXML
	private TextField detalhesEquipamento;
	
	
	//FAZER O NOVO TIPO DE EQUIPAMENTO E NOVO SUB TIPO DE EQUIPAMENTO
	@FXML
	private void initialize(){
		estadoEquipamento.getItems().addAll(Equipamento.Estado.values());
		tipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaTiposEquipamentos());
		//subTipoEquipamento.getItems().addAll(NovoSubTipoEquipamento.selecionaSubTiposEquipamentos());
                tipoEquipamento.onActionProperty().addListener((obs,oldvalue,newvalue)->{
                   String nome = tipoEquipamento.getSelectionModel().getSelectedItem();
                   subTipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaSubTiposEquipamentos(nome));
                });
	}
	
	
	@FXML
	public void guardarInfo(){
		
		Equipamento novoEquipamento = new Equipamento(marcaEquipamento.getText(), modeloEquipamento.getText(), detalhesEquipamento.getText(), 
				numeroSerieEquipamento.getText(), tipoEquipamento.getValue(), subTipoEquipamento.getValue().toString(), estadoEquipamento.getValue());
		
		novoEquipamento.inserirEquipamento(novoEquipamento);
	}

}
