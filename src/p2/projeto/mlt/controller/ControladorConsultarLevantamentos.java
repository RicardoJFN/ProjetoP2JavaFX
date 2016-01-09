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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import p2.projeto.mlt.model.Levantamento;

/**
 *
 * @author carlosb
 */
public class ControladorConsultarLevantamentos {
    
      @FXML
 private javafx.scene.control.Button sair;
      
      
        @FXML
        private TableView<Levantamento> tabelaLevantamento;
        @FXML
        private TableColumn<Levantamento, Double> numero;
        @FXML
        private TableColumn<Levantamento, Integer> data;
       
        
        private ObservableList<Levantamento> levantamentos = FXCollections.observableArrayList();
        
        
        public ObservableList<Levantamento> getDataLevantamento(){
            return levantamentos;
        }
        
        
        @FXML
        private void initialize(){
            tabelaLevantamento.setEditable(true);
            //numero.setCellValueFactory(cellData -> cellData.getValue().getNumLevantamento());
        }
        
    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage consultarLevantamentos = (Stage) sair.getScene().getWindow();
            consultarLevantamentos.close();
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
     /**
     * Metodo para botao ver levantamento presente na janela Consultarlevantamentos -
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
        }

    }
    
}
