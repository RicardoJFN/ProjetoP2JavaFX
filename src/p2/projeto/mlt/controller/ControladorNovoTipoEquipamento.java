/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.model.NovoTipoEquipamento;

/**
 *
 * @author ricardon
 */
public class ControladorNovoTipoEquipamento {
    
    @FXML
    private TextField tipoEquipamento;
    @FXML
    private TextField subTipoEquipamento;
    
    private Stage stageTipoEquipamento;
   
    
    
    @FXML
    private void initialize(){
        
    }
    
    public void setNovoTipoEquipamento(Stage stageTipoEquipamento){
        this.stageTipoEquipamento = stageTipoEquipamento;
    }
    
    public void executar(){
       NovoTipoEquipamento novoTipo = new NovoTipoEquipamento(tipoEquipamento.getText(), subTipoEquipamento.getText());
       novoTipo.inserirTipoEquipamento(novoTipo);
       
    }
}
