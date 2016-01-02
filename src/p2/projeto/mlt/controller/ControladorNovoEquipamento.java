/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.util.ArrayList;
import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Edificio;
import p2.projeto.mlt.model.Equipamento;
import p2.projeto.mlt.model.Equipamento.Estado;
import p2.projeto.mlt.model.NovoSubTipoEquipamento;
import p2.projeto.mlt.model.NovoTipoEquipamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoEquipamento {
    
	@FXML
	private ComboBox<String> tipoEquipamento;
	@FXML
	private ComboBox<NovoSubTipoEquipamento> subTipoEquipamento;
        @FXML
        private ComboBox<Edificio> edificio;
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
        
	//FAZER O NOVO TIPO DE EQUIPAMENTO E NOVO SUB TIPO DE EQUIPAMENTO
	@FXML
	private void initialize(){
		estadoEquipamento.getItems().addAll(Equipamento.Estado.values());
		tipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaTiposEquipamentos());
                subTipoEquipamento.getItems().addAll(NovoSubTipoEquipamento.selecionaSubTipos());
                edificio.getItems().addAll(Edificio.selecionaEdificio());
                //subTipoEquipamento.getItems().addAll(NovoSubTipoEquipamento.selecionaSubTiposEquipamentos());
                /*tipoEquipamento.onActionProperty().addListener((obs,oldvalue,newvalue)->{
                   String nome = tipoEquipamento.getSelectionModel().getSelectedItem();
                   subTipoEquipamento.getItems().addAll(NovoTipoEquipamento.selecionaSubTiposEquipamentos(nome));
                });
                */
	}
	
	
	@FXML
	public void guardarInfo(){
		
		Equipamento novoEquipamento = new Equipamento(tipoEquipamento.getValue(),subTipoEquipamento.getValue(),edificio.getValue(),marcaEquipamento.getText(), modeloEquipamento.getText(), 
                        numeroSerieEquipamento.getText(), detalhesEquipamento.getText(), estadoEquipamento.getValue());
		
		novoEquipamento.inserirEquipamento(novoEquipamento);
	}
  /**
     * Metodo para botao Criar Novo Tipo de Equipamento caso nao exista na listagem - botao
     * de passagem para view CriarNovoTipoEquipamento
     */
    @FXML
    private void criarNovoTipoEquipamento() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoTipoEquipamento.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Tipo Equipamento");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
        }

    } 
        
}
