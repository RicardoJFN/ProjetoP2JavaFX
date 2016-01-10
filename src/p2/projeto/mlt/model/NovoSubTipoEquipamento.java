/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

public class NovoSubTipoEquipamento {

    protected IntegerProperty idSubTipo;
    protected StringProperty nomeSubTipo;

    public NovoSubTipoEquipamento(int idSubTipo, String nomeSubTipo) {
        this.idSubTipo = new SimpleIntegerProperty(idSubTipo);
        this.nomeSubTipo = new SimpleStringProperty(nomeSubTipo);
    }

    public NovoSubTipoEquipamento(String nomeSubTipo) {
        this.nomeSubTipo = new SimpleStringProperty(nomeSubTipo);
    }

    public IntegerProperty getIdSubTipo() {
        return idSubTipo;
    }

    public void setIdSubTipo(IntegerProperty idSubTipo) {
        this.idSubTipo = idSubTipo;
    }

    public StringProperty getNomeSubTipo() {
        return nomeSubTipo;
    }

    public void setNomeSubTipo(StringProperty nomeSubTipo) {
        this.nomeSubTipo = nomeSubTipo;
    }

    @Override
    public String toString() {
        return "Sub Tipo Equipamento: " + nomeSubTipo.getValue();
    }

    public void inserirNovoSubTipoEquipamento(NovoSubTipoEquipamento novoSubTipoEquipamento) {
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO sbtequip(Sbtequip_id,Sbtequip_sbtipo)VALUES(?,?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);

            ps.setString(1, Integer.toString(idSubTipo.getValue()));
            ps.setString(2, nomeSubTipo.getValue());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> selecionaSubTiposEquipamentos() {

        ArrayList<String> subTipos = new ArrayList<>();
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            Statement stmt = con.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Sbtequip_sbtipo FROM sbtequip");

            while (rs.next()) {
                subTipos.add(rs.getString("Sbtequip_sbtipo"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return subTipos;

    }

    public static ArrayList<NovoSubTipoEquipamento> selecionaSubTipos() {
        ArrayList<NovoSubTipoEquipamento> subTipos = new ArrayList<>();
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            Statement stmt = con.getConexao().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sbtequip");
            while (rs.next()) {
                subTipos.add(new NovoSubTipoEquipamento(rs.getInt("Sbtequip_id"), rs.getString("Sbtequip_sbtipo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subTipos;
    }
}
