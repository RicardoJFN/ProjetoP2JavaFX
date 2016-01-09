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
import p2.projeto.mlt.model.Cliente;

/**
 *
 * @author carlosb
 */

public class ControladorConsultarClientes {
    
    /**
     * Indicacao dos nomes referentes ao botao sair
     * referente TableView e respectivas colunas da Tableview:
     * nome, morada, localidade, telefone, email
     */
    
    @FXML
    private javafx.scene.control.Button sair;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<Cliente, String> nome;
    @FXML
    private TableColumn<Cliente, String> morada;
    @FXML
    private TableColumn<Cliente, String> localidade;
    @FXML
    private TableColumn<Cliente, Integer> telefone;
    @FXML
    private TableColumn<Cliente, String> email;
    
    /**
     * 
     */
    
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
        
        public ObservableList<Cliente> getClienteData(){
            return clientes;
        }
    /**
     * 
     */
        
    @FXML
    private void initialize(){
    
        clientes = FXCollections.observableArrayList(Cliente.selecionaCliente());
        nome.setCellValueFactory(cellData -> cellData.getValue().getNomeCliente());
        morada.setCellValueFactory(cellData -> cellData.getValue().getMoradaCliente());
        email.setCellValueFactory(cellData -> cellData.getValue().getEmailCliente());
        tabelaCliente.setItems(clientes);
       
    }
    
    /**
     * Metodo para botao Voltar que vai permitir voltar a janela anterior
     */
    
    @FXML
    public void voltaMenuPrincipal() {
        try {
            Stage consultarClientes = (Stage) sair.getScene().getWindow();
            consultarClientes.close();
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
     * Metodo para botao ver cliente presente na janela ConsultarClientes -
     * botao para view ConsultarDetalheCliente que vai permitir ver todos os
     * dados do cliente 
     */
    
    @FXML
    private void mostraDetalheCliente() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/p2/projeto/mlt/view/ConsultarDetalheCliente.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ficha Cliente");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
