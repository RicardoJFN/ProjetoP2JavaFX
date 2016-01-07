/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.util.ArrayList;
import java.util.Random;
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
import p2.projeto.mlt.model.Levantamento;
import p2.projeto.mlt.model.NovoSubTipoEquipamento;
import p2.projeto.mlt.model.NovoTipoEquipamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoEquipamento {
    
    
        @FXML
        private ComboBox<Levantamento> numeroLevantamento;
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
        private TextField valorEquipamento;
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
                numeroLevantamento.getItems().addAll(Levantamento.selecionaLevantamento());
                
	}
	
        @FXML
        public void calcularValor(){
           int chiller = 6, painel = 2, ventilador = 3, uta = 4, depositoInercia = 5, caldeira = 6;
           Random rnd = new Random();
           int valManutencao = rnd.nextInt(6) + 5;
           int estadoExcelente = 1, estadoRazoavel = 5, estadoDegradado = 10;
           int valorTotal = 0;
           
           if(Estado.DEGRADADO == estadoEquipamento.getValue()){
               switch (tipoEquipamento.getValue()) {
                   case "Chiller":
                       valorTotal = chiller * valManutencao * estadoDegradado;
                       break;
                   case "Paineis":
                       valorTotal = painel * valManutencao * estadoDegradado;
                       break;
                   case "Ventiladores":
                       valorTotal = ventilador * valManutencao * estadoDegradado;
                       break;
                   case "Utas":
                       valorTotal = uta * valManutencao * estadoDegradado;
                       break;
                   case "Depósitos Inercia":
                       valorTotal = depositoInercia * valManutencao * estadoDegradado;
                       break;
                   case "Caldeiras":
                       valorTotal = caldeira * valManutencao * estadoDegradado;
                       break;
               }
           }else if(Estado.RAZOAVEL == estadoEquipamento.getValue()){
               switch (tipoEquipamento.getValue()) {
                   case "Chiller":
                       valorTotal = chiller * valManutencao * estadoRazoavel;
                       break;
                   case "Paineis":
                       valorTotal = painel * valManutencao * estadoRazoavel;
                       break;
                   case "Ventiladores":
                       valorTotal = ventilador * valManutencao * estadoRazoavel;
                       break;
                   case "Utas":
                       valorTotal = uta * valManutencao * estadoRazoavel;
                       break;
                   case "Depósitos Inercia":
                       valorTotal = depositoInercia * valManutencao * estadoRazoavel;
                       break;
                   case "Caldeiras":
                       valorTotal = caldeira * valManutencao * estadoRazoavel;
                       break;
               }
           }else {
               switch (tipoEquipamento.getValue()) {
                   case "Chiller":
                       valorTotal = chiller * valManutencao * estadoExcelente;
                       break;
                   case "Paineis":
                       valorTotal = painel * valManutencao * estadoExcelente;
                       break;
                   case "Ventiladores":
                       valorTotal = ventilador * valManutencao * estadoExcelente;
                       break;
                   case "Utas":
                       valorTotal = uta * valManutencao * estadoExcelente;
                       break;
                   case "Depósitos Inercia":
                       valorTotal = depositoInercia * valManutencao * estadoExcelente;
                       break;
                   case "Caldeiras":
                       valorTotal = caldeira * valManutencao * estadoExcelente;
                       break;
               }
           }
           
           valorEquipamento.setText(Integer.toString(valorTotal));
        }
	
	@FXML
	public void guardarInfo(){
		
		Equipamento novoEquipamento = new Equipamento(tipoEquipamento.getValue(),numeroLevantamento.getValue(),subTipoEquipamento.getValue(),edificio.getValue(),marcaEquipamento.getText(), modeloEquipamento.getText(), 
                        numeroSerieEquipamento.getText(), detalhesEquipamento.getText(), Double.parseDouble(valorEquipamento.getText()),estadoEquipamento.getValue());
		
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
