/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.awt.Desktop;
import java.io.File;
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

/**
 *
 * @author 
 */
public class ControladorNovoLevantamento {

    @FXML
    private TextField numeroLevantamento;
    @FXML
    private TextField dataLevantamento;
    @FXML
    private ComboBox<String> nomeCliente;
    @FXML
    private ComboBox<Edificio> numeroEdificio;
    @FXML
    private TextField primeiroPontoLat;
    @FXML
    private TextField primeiroPontoLong;
    @FXML
    private TextField segundoPontoLat;
    @FXML
    private TextField segundoPontoLong;
    @FXML
    private TextField terceiroPontoLat;
    @FXML
    private TextField terceiroPontoLong;
    @FXML
    private TextField quartoPontoLat;
    @FXML
    private TextField quartoPontoLong;
    @FXML
    private TextField areaTotal;
    @FXML
    private javafx.scene.control.Button voltar;
    @FXML
    private javafx.scene.control.Button sair;
    
    private Stage novoLevantamento;

    private boolean janelaLevantamento = false;

    @FXML
    private void initialize() {

        nomeCliente.getItems().addAll(Cliente.selecionaNomesCliente());
        numeroEdificio.getItems().addAll(Edificio.selecionaEdificio());

    }

    public void setNovoLevantamento(Stage novoLevantamento) {
        this.novoLevantamento = novoLevantamento;
    }

    public boolean isJanelaLevantamento() {
        return janelaLevantamento;
    }

    @FXML
    public void mostraJanelaNovoCliente() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoCliente.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Cliente");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostraJanelaNovoEdificio() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarNovoEdificio.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Novo Edificio");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostraJanelaIdentificarEquipamentos() {
        try {
            Stage criarNovoLevantamento = (Stage) sair.getScene().getWindow();
            criarNovoLevantamento.hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/IdentificarEquipamentos.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Identificacao de Equipamentos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage criarNovoLevantamento = (Stage) voltar.getScene().getWindow();
            criarNovoLevantamento.close();
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
    public void obterCoord() {

        try {
            File htmlFile = new File("C:\\\\Users\\\\pedror\\\\Documents\\\\ProjetoP2\\\\GoogleMaps.html");
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void calcularArea() {
        double primeiraMultiDireita = Double.parseDouble(primeiroPontoLat.getText()) * Double.parseDouble(segundoPontoLong.getText());
        double segundaMultiDireita = Double.parseDouble(segundoPontoLat.getText()) * Double.parseDouble(terceiroPontoLong.getText());
        double terceiraMultiDireita = Double.parseDouble(terceiroPontoLat.getText()) * Double.parseDouble(quartoPontoLong.getText());
        double quartaMultiDireita = Double.parseDouble(quartoPontoLat.getText()) * Double.parseDouble(primeiroPontoLong.getText());

        double resultadoSomaDireita = primeiraMultiDireita + segundaMultiDireita + terceiraMultiDireita + quartaMultiDireita;

        double primeiraMultiEsquerda = Double.parseDouble(primeiroPontoLong.getText()) * Double.parseDouble(segundoPontoLat.getText());
        double segundaMultiEsquerda = Double.parseDouble(segundoPontoLong.getText()) * Double.parseDouble(terceiroPontoLat.getText());
        double terceiraMultiEsquerda = Double.parseDouble(terceiroPontoLong.getText()) * Double.parseDouble(quartoPontoLat.getText());
        double quartaMultiEsquerda = Double.parseDouble(quartoPontoLong.getText()) * Double.parseDouble(primeiroPontoLat.getText());

        double resultadoSomaEsquerda = primeiraMultiEsquerda + segundaMultiEsquerda + terceiraMultiEsquerda + quartaMultiEsquerda;

        double resultadoSomas = Math.max(resultadoSomaDireita, resultadoSomaEsquerda);
        double sub = 0;
        if (resultadoSomas == resultadoSomaDireita) {
            sub = resultadoSomaDireita - resultadoSomaEsquerda;
        } else {
            sub = resultadoSomaEsquerda - resultadoSomaDireita;
        }

        double resultadoFinal = sub / 2;

        areaTotal.setText(Double.toString(resultadoFinal));
    }

    @FXML
    public void guardarInfo() {

        try {

            Levantamento novoLevantamento = new Levantamento(Integer.parseInt(numeroLevantamento.getText()), Integer.parseInt(dataLevantamento.getText()),
                    Double.parseDouble(primeiroPontoLat.getText()), Double.parseDouble(primeiroPontoLong.getText()), Double.parseDouble(segundoPontoLat.getText()), Double.parseDouble(segundoPontoLong.getText()),
                    Double.parseDouble(terceiroPontoLat.getText()), Double.parseDouble(terceiroPontoLong.getText()), Double.parseDouble(quartoPontoLat.getText()), Double.parseDouble(quartoPontoLong.getText()),
                    Double.parseDouble(areaTotal.getText()), numeroEdificio.getValue());

            novoLevantamento.inserirNovoLevantamento();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
