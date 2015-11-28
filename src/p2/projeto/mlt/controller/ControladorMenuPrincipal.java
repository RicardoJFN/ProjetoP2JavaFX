/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ricardon
 */
public class ControladorMenuPrincipal {
    
    private MainApp mainApp;
    
    @FXML
    Button novoLevantamento = new Button();
    Button elaborarOrcamento = new Button();
    Button consultaLevantamentos = new Button();
    Button consultaClientes = new Button();
    Button consultaOrcamentos = new Button();
    private Stage menuPrincipal;
    
  @FXML
  private void initialize(){
      
  }
  
  public void setMainApp(MainApp mainApp){
      this.mainApp = mainApp;
  }
  
  public void setMenuPrincipal(Stage menuPrincipal){
      this.menuPrincipal = menuPrincipal;
  }
    
  @FXML
  public void sair(){
      
      menuPrincipal.close();
  }
  
  
  @FXML
  private void mostraNovoLevantamento(){
      
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriarLevantamento.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Novo Levantamento");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
      
  }
  
   /**
     * Metodo para botao Elaborar Orcamento presente no menu principal - botão de passagem para view CriacaoOrcamento
     * @param mostraElaborarOrcamento
     */
    @FXML
  private void mostraElaborarOrcamento(){
      
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/CriacaoOrcamento.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Elaborar Orçamento");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
      
  }
  
     /**
     * Metodo para botao Consultar levantamentos Efetuados presente no menu principal - botão de passagem para view ConsultaLevantamentos
     * @param mostraConsultaLevantamentos
     */
    @FXML
  private void mostraConsultaLevantamentos(){
      
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultaLevantamentos.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Consulta Levantamentos");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
      
  }
  
       /**
     * Metodo para botao Consultar Clientes presente no menu principal - botão de passagem para view ConsultaClientes
     * @param mostraConsultaClientes
     */
    @FXML
  private void mostraConsultaClientes(){
      
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultaClientes.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Consulta Clientes");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
      
  }
  
         /**
     * Metodo para botao Consultar Orcamentos presente no menu principal - botão de passagem para view ConsultaOrcamentos
     * @param mostraConsultaOrcamentos
     */
    @FXML
  private void mostraConsultaOrcamentos(){
      
      try {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultaOrcamentos.fxml"));
          Parent root = (Parent) fxmlLoader.load();
          Stage stage = new Stage();
          stage.setTitle("Consulta Orçamentos");
          stage.setScene(new Scene(root));
          stage.show();
      } catch (Exception e) {
      }
      
      
  }
}
