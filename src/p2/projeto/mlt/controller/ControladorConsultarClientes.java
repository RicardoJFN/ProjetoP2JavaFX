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
import javafx.stage.Stage;

/**
 *
 * @author carlosb
 */
public class ControladorConsultarClientes {
    
          @FXML
 private javafx.scene.control.Button sair;
    
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
        }

    }
}
