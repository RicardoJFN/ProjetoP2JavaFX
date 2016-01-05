/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import p2.projeto.mlt.model.Cliente;

/**
 *
 * @author carlosb
 */
public class ControladorConsultarClientes {
    
    @FXML
    private javafx.scene.control.Button sair;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<Cliente, Cliente> nome;
    @FXML
    private TableColumn<Cliente, String> morada;
    @FXML
    private TableColumn<Cliente, String> localidade;
    @FXML
    private TableColumn<Cliente, Integer> telefone;
    @FXML
    private TableColumn<Cliente, String> email;
    
    
    @FXML
    private void initialize(){
       Cliente clientes = null;
       
       //nome.getColumns().add(clientes.getNomeCliente());
    }
    
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
