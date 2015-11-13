/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardon
 */
public class ConexaoBaseDados {
    
    //Uso do Singleton
    public static ConexaoBaseDados instance;
    private Connection conexao;
    
    private ConexaoBaseDados() {
        try {
            //forName = driver da BD
            Class.forName("");
            //Inserir depois  caminho, login e password
            conexao = DriverManager.getConnection(null, null, null);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoBaseDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public synchronized ConexaoBaseDados estadoConexao(){
        if(instance == null) {
            instance = new ConexaoBaseDados();
        }
        return instance;
    }

    public Connection getConexao() {
        return conexao;
    }
    
    public void encerrarConexao() {
        instance = null;
    }
}
