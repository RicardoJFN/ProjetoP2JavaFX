/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.DAL;

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
    
    private Connection conexao;
    private static ConexaoBaseDados singleton = null;
    private static final String Nomehost = "";
    private static final String Nomebd = "";
    private static final String driverString = "";
    private static final String driverPath = "";
    private static final String password = "";
    private static final String user = "";

    private ConexaoBaseDados(String driverClassName, String dbURL, String user, String password) throws ClassNotFoundException, SQLException{
        Class.forName(driverClassName);
        conexao = DriverManager.getConnection(dbURL, user, password);
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    public static ConexaoBaseDados conectar() throws ClassNotFoundException, SQLException{
        if (singleton == null){
            singleton = new ConexaoBaseDados(driverPath, driverString+"://"+Nomehost+"/"+Nomebd,user,password);
        }
        return singleton;
    }
    
    public void encerrarBaseDados() throws SQLException{
        if(conexao != null){
            conexao.close();
        }
        singleton = null;
    }
    
    
}
