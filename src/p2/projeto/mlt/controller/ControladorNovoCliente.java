/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import p2.projeto.mlt.DAL.ConexaoBaseDados;
import p2.projeto.mlt.model.Cliente;
import p2.projeto.mlt.model.IMetodosBD;

/**
 *
 * @author ricardon
 */
public class ControladorNovoCliente implements IMetodosBD{
    
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField moradaCliente;
    @FXML
    private TextField postalCliente;
    @FXML
    private TextField localidadeCliente;
    @FXML
    private TextField telefoneCliente;
    @FXML
    private TextField telemovelCliente;
    @FXML
    private TextField emailCliente;
    
    private Stage novoCliente;
    private Cliente cliente;
    private static final String SQL_INSERT = "INSERT INTO Cliente (Cliente_nome, Cliente_morada, Cliente_postal, Cliente_telef, Cliente_telem, Cliente_email, Cliente_local) VALUES (?,?,?,?,?,?,?)";
    
    private static final ConexaoBaseDados conectar = ConexaoBaseDados.instance.estadoConexao();
    
    @FXML
    private void initialize(){
        
    }
    
    public void setNovoCliente(Stage novoCliente){
        this.novoCliente = novoCliente;
    }

    @Override
    public boolean inserir() {
       PreparedStatement ps;
        
        try {
            ps = conectar.getConexao().prepareCall(SQL_INSERT);
            
            ps.setString(1, nomeCliente.getText());
            ps.setString(2, moradaCliente.getText());
            ps.setString(3, postalCliente.getText());
            ps.setString(4, telefoneCliente.getText());
            ps.setString(5, telemovelCliente.getText());
            ps.setString(6, emailCliente.getText());
            ps.setString(7, localidadeCliente.getText());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorNovoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return false;
    }
    
   
    
}
