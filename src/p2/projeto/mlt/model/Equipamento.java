/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

public class Equipamento {

	protected IntegerProperty idEquip;
	protected StringProperty marcaEquip;
	protected StringProperty modeloEquip;
	protected StringProperty detalhesEquip;
	protected StringProperty serieEquip;
	protected StringProperty tipoEquip;
	protected StringProperty subTipoEquip;
	protected Estado estadoEquip;
	
	public enum Estado {EXCELENTE, RAZOAVEL, DEGRADADO};
	
	public Equipamento(int idEquip, String marcaEquip, String modeloEquip, String detalhesEquip, String serieEquip,
			String tipoEquip, String subTipoEquip, Estado estadoEquip){
		this.idEquip = new SimpleIntegerProperty(idEquip);
		this.marcaEquip = new SimpleStringProperty(marcaEquip);
		this.modeloEquip = new SimpleStringProperty(modeloEquip);
		this.detalhesEquip = new SimpleStringProperty(detalhesEquip);
		this.serieEquip = new SimpleStringProperty(serieEquip);
		this.tipoEquip = new SimpleStringProperty(tipoEquip);
		this.subTipoEquip = new SimpleStringProperty(subTipoEquip);
		this.estadoEquip = estadoEquip;
	}
	
	public Equipamento(String marcaEquip, String modeloEquip, String detalhesEquip, String serieEquip,
			String tipoEquip, String subTipoEquip, Estado estadoEquip){
		this.marcaEquip = new SimpleStringProperty(marcaEquip);
		this.modeloEquip = new SimpleStringProperty(modeloEquip);
		this.detalhesEquip = new SimpleStringProperty(detalhesEquip);
		this.serieEquip = new SimpleStringProperty(serieEquip);
		this.tipoEquip = new SimpleStringProperty(tipoEquip);
		this.subTipoEquip = new SimpleStringProperty(subTipoEquip);
		this.estadoEquip = estadoEquip;
	}

	
	
	public IntegerProperty getIdEquip() {
		return idEquip;
	}

	public void setIdEquip(IntegerProperty idEquip) {
		this.idEquip = idEquip;
	}

	public StringProperty getMarcaEquip() {
		return marcaEquip;
	}

	public void setMarcaEquip(StringProperty marcaEquip) {
		this.marcaEquip = marcaEquip;
	}

	public StringProperty getModeloEquip() {
		return modeloEquip;
	}

	public void setModeloEquip(StringProperty modeloEquip) {
		this.modeloEquip = modeloEquip;
	}

	public StringProperty getDetalhesEquip() {
		return detalhesEquip;
	}

	public void setDetalhesEquip(StringProperty detalhesEquip) {
		this.detalhesEquip = detalhesEquip;
	}

	public StringProperty getSerieEquip() {
		return serieEquip;
	}

	public void setSerieEquip(StringProperty serieEquip) {
		this.serieEquip = serieEquip;
	}

	public StringProperty getTipoEquip() {
		return tipoEquip;
	}

	public void setTipoEquip(StringProperty tipoEquip) {
		this.tipoEquip = tipoEquip;
	}

	public StringProperty getSubTipoEquip() {
		return subTipoEquip;
	}

	public void setSubTipoEquip(StringProperty subTipoEquip) {
		this.subTipoEquip = subTipoEquip;
	}

	public Estado getEstadoEquip() {
		return estadoEquip;
	}

	public void setEstadoEquip(Estado estadoEquip) {
		this.estadoEquip = estadoEquip;
	}

	public void inserirEquipamento(Equipamento equipamento){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO equipamento(Equip_marca,Equip_model,Equip_detalhes,Equip_serie,Equip_tipo,Equip_sbtipo,Equip_estado)VALUES(?,?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setString(1, marcaEquip.getValue());
			ps.setString(2, modeloEquip.getValue());
			ps.setString(3, detalhesEquip.getValue());
			ps.setString(4, serieEquip.getValue());
			ps.setString(5, tipoEquip.getValue());
			ps.setString(6, subTipoEquip.getValue());
			ps.setString(7, estadoEquip.name());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
