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
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import p2.projeto.mlt.DAL.ConexaoBaseDados;

public class Equipamento {

	protected IntegerProperty idEquip;
        protected StringProperty tipoEquip;
        protected ObjectProperty<Levantamento> levantamento;
	protected ObjectProperty<NovoSubTipoEquipamento> subTipoEquip;
        protected ObjectProperty<Edificio> edificio;
	protected StringProperty marcaEquip;
	protected StringProperty modeloEquip;
        protected StringProperty serieEquip;
	protected StringProperty detalhesEquip;
        protected DoubleProperty valorEquip;
	protected Estado estadoEquip;

	public enum Estado {EXCELENTE, RAZOAVEL, DEGRADADO};
	
	public Equipamento(int idEquip, String tipoEquip, Levantamento levantamento,NovoSubTipoEquipamento subTipoEquip, Edificio edificio, 
                String marcaEquip, String modeloEquip, String serieEquip, String detalhesEquip, double valorEquip,Estado estadoEquip){
            this.idEquip = new SimpleIntegerProperty(idEquip);
            this.tipoEquip = new SimpleStringProperty(tipoEquip);
            this.levantamento = new SimpleObjectProperty<>(levantamento);
            this.subTipoEquip = new SimpleObjectProperty<>(subTipoEquip);
            this.edificio = new SimpleObjectProperty<>(edificio);
            this.marcaEquip = new SimpleStringProperty(marcaEquip);
            this.modeloEquip = new SimpleStringProperty(modeloEquip);
            this.serieEquip = new SimpleStringProperty(serieEquip);
            this.detalhesEquip = new SimpleStringProperty(detalhesEquip);
            this.valorEquip = new SimpleDoubleProperty(valorEquip);
            this.estadoEquip = estadoEquip;
        }
	
	public Equipamento(String tipoEquip, Levantamento levantamento,NovoSubTipoEquipamento subTipoEquip, Edificio edificio, 
                String marcaEquip, String modeloEquip, String serieEquip, String detalhesEquip, double valorEquip,Estado estadoEquip){
            this.tipoEquip = new SimpleStringProperty(tipoEquip);
            this.levantamento = new SimpleObjectProperty<>(levantamento);
            this.subTipoEquip = new SimpleObjectProperty<>(subTipoEquip);
            this.edificio = new SimpleObjectProperty<>(edificio);
            this.marcaEquip = new SimpleStringProperty(marcaEquip);
            this.modeloEquip = new SimpleStringProperty(modeloEquip);
            this.serieEquip = new SimpleStringProperty(serieEquip);
            this.detalhesEquip = new SimpleStringProperty(detalhesEquip);
            this.valorEquip = new SimpleDoubleProperty(valorEquip);
            this.estadoEquip = estadoEquip;
        }

        
        public Equipamento(double valorEquip){
            this.valorEquip = new SimpleDoubleProperty(valorEquip);
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

        public ObjectProperty<NovoSubTipoEquipamento> getSubTipoEquip() {
            return subTipoEquip;
        }

        public void setSubTipoEquip(ObjectProperty<NovoSubTipoEquipamento> subTipoEquip) {
            this.subTipoEquip = subTipoEquip;
        }

        public ObjectProperty<Edificio> getEdificio() {
            return edificio;
        }

        public void setEdificio(ObjectProperty<Edificio> edificio) {
            this.edificio = edificio;
        }

	

	public Estado getEstadoEquip() {
		return estadoEquip;
	}

	public void setEstadoEquip(Estado estadoEquip) {
		this.estadoEquip = estadoEquip;
	}

        public ObjectProperty<Levantamento> getLevantamento() {
            return levantamento;
        }

        public void setLevantamento(ObjectProperty<Levantamento> levantamento) {
            this.levantamento = levantamento;
        }

        public DoubleProperty getValorEquip() {
            return valorEquip;
        }

        public void setValorEquip(DoubleProperty valorEquip) {
            this.valorEquip = valorEquip;
        }
        
        

	public void inserirEquipamento(Equipamento equipamento){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO equipamento(Equip_marca,Equip_model,Equip_detalhes,Equip_serie,Equip_tipo,Equip_estado,Equip_Edif_id,Equip_Sbtequip_id,Equip_Lev_id,Equip_valorestado)VALUES(?,?,?,?,?,?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
                        ps.setString(1, marcaEquip.getValue());
                        ps.setString(2, modeloEquip.getValue());
                        ps.setString(3, detalhesEquip.getValue());
                        ps.setString(4, serieEquip.getValue());
                        ps.setString(5, tipoEquip.getValue());
                        ps.setString(6, estadoEquip.name());
                        ps.setInt(7, edificio.getValue().getIdEdificio().getValue());
                        ps.setInt(8, subTipoEquip.getValue().getIdSubTipo().getValue());
                        ps.setInt(9, levantamento.getValue().getIdLevantamento().getValue());
                        ps.setDouble(10, valorEquip.getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
        public static ArrayList<Double> selecionaValorEquipamento(){
		
		ArrayList<Double> equipamentos = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Equip_valorestado FROM equipamento");
			
			while(rs.next()){
                            equipamentos.add(rs.getDouble("Equip_valorestado"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return equipamentos;
	}
	
}
