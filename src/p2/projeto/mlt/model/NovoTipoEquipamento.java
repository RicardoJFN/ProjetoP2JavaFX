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

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

public class NovoTipoEquipamento {

	protected IntegerProperty idTipo;
	protected StringProperty tipo;
	protected DoubleProperty valor;
	protected StringProperty subTipo;
	
	public NovoTipoEquipamento(int idTipo, String tipo, double valor, String subTipo){
		this.idTipo = new SimpleIntegerProperty(idTipo);
		this.tipo = new SimpleStringProperty(tipo);
		this.valor = new SimpleDoubleProperty(valor);
		this.subTipo = new SimpleStringProperty(subTipo);
	}
	
	public NovoTipoEquipamento(String tipo, double valor, String subTipo){
		this.tipo = new SimpleStringProperty(tipo);
		this.valor = new SimpleDoubleProperty(valor);
		this.subTipo = new SimpleStringProperty(subTipo);
	}

	public IntegerProperty getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(IntegerProperty idTipo) {
		this.idTipo = idTipo;
	}

	public StringProperty getTipo() {
		return tipo;
	}

	public void setTipo(StringProperty tipo) {
		this.tipo = tipo;
	}

	public DoubleProperty getValor() {
		return valor;
	}

	public void setValor(DoubleProperty valor) {
		this.valor = valor;
	}

	public StringProperty getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(StringProperty subTipo) {
		this.subTipo = subTipo;
	}

	@Override
	public String toString() {
		return "NovoTipoEquipamento [idTipo=" + idTipo + ", tipo=" + tipo + ", valor=" + valor + ", subTipo=" + subTipo
				+ "]";
	}
	
	public void inserirNovoTipoEquipamento(NovoTipoEquipamento novoTipoEquipamento){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO tequip(Tequip_id,Tequip_tipo,Tequip_tvalor,Tequip_Sbtequip_id)VALUES(?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setString(1, Integer.toString(idTipo.getValue()));
			ps.setString(2, tipo.getValue());
			ps.setString(3, Double.toString(valor.getValue()));
			ps.setString(4, subTipo.getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> selecionaTiposEquipamentos(){
			
			ArrayList<String> tipos = new ArrayList<>();
			try {
				ConexaoBaseDados con = ConexaoBaseDados.conectar();
				Statement stmt = con.getConexao().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT Tequip_tipo FROM tequip");
				
				while(rs.next()){
					tipos.add(rs.getString("Tequip_tipo"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tipos;
			
		}
	

        public static ArrayList<NovoTipoEquipamento> selecionaSubTiposEquipamentos(String tipo){
			
			ArrayList <NovoTipoEquipamento> subTipos = new ArrayList<>();
			try {
				ConexaoBaseDados con = ConexaoBaseDados.conectar();
				Statement stmt = con.getConexao().createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM TipoEquipamento WHERE tipo = "+tipo);
				
				while(rs.next()){
					subTipos.add(new NovoTipoEquipamento(rs.getInt("idTipo"), rs.getString("tipo"), rs.getDouble("valor"), rs.getString("subTipo")));
				}
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			return subTipos;
			
		}
	
}
