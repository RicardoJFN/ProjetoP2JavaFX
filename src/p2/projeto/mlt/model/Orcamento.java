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
import p2.projeto.mlt.DAL.ConexaoBaseDados;

/**
 *
 * @author ricardon
 */
public class Orcamento {
    
    protected IntegerProperty idOrcamento;
    protected IntegerProperty dataOrcamento;
    protected ObjectProperty<Cliente> cliente;
    protected ObjectProperty<Edificio> edficio;
    protected ObjectProperty<Levantamento> levantamento;
    protected DoubleProperty valorEquipamento;
    
    public Orcamento(int idOrcamento, int dataOrcamento, Cliente cliente, Edificio edificio, Levantamento levantamento, double valorEquipamento){
        this.idOrcamento = new SimpleIntegerProperty(idOrcamento);
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
        this.cliente = new SimpleObjectProperty<>(cliente);
        this.edficio = new SimpleObjectProperty<>(edificio);
        this.levantamento = new SimpleObjectProperty<>(levantamento);
        this.valorEquipamento = new SimpleDoubleProperty(valorEquipamento);
    }
    
    public Orcamento(int dataOrcamento, Edificio edificio , Cliente cliente, Levantamento levantamento, double valorEquipamento){
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
        this.edficio = new SimpleObjectProperty<>(edificio);
        this.cliente = new SimpleObjectProperty<>(cliente);
        this.levantamento = new SimpleObjectProperty<>(levantamento);
        this.valorEquipamento = new SimpleDoubleProperty(valorEquipamento);
    }
    
    public Orcamento(int idOrcamento, int dataOrcamento){
        this.idOrcamento = new SimpleIntegerProperty(idOrcamento);
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
    }
    
    public Orcamento(int dataOrcamento){
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
    }

    public IntegerProperty getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(IntegerProperty idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public IntegerProperty getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(IntegerProperty dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    public ObjectProperty<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(ObjectProperty<Cliente> cliente) {
        this.cliente = cliente;
    }

    public ObjectProperty<Edificio> getEdficio() {
        return edficio;
    }

    public void setEdficio(ObjectProperty<Edificio> edficio) {
        this.edficio = edficio;
    }

    public ObjectProperty<Levantamento> getLevantamento() {
        return levantamento;
    }

    public void setLevantamento(ObjectProperty<Levantamento> levantamento) {
        this.levantamento = levantamento;
    }

    public DoubleProperty getValorEquipamento() {
        return valorEquipamento;
    }

    public void setValorEquipamento(DoubleProperty valorEquipamento) {
        this.valorEquipamento = valorEquipamento;
    }

    @Override
    public String toString() {
        return "Orcamento{" + "idOrcamento=" + idOrcamento + ", dataOrcamento=" + dataOrcamento + ", cliente=" + cliente + ", edficio=" + edficio + ", levantamento=" + levantamento + '}';
    }
    
    
	public void inserirNovoOrcamento(){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO orcamento(Orc_data,Orc_Edif_id,Orc_Cliente_id,Orc_Lev_id,Orc_Equip_valorestado)VALUES(?,?,?,?,?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setInt(1, dataOrcamento.getValue());
                        ps.setInt(2, edficio.getValue().getIdEdificio().getValue());
                        ps.setInt(3, cliente.getValue().getIdCliente().getValue());
                        ps.setInt(4, levantamento.getValue().getIdLevantamento().getValue());
                        ps.setDouble(5, valorEquipamento.getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
        
        public static ArrayList<Orcamento> selecionaOrcamentos(){
            ArrayList<Orcamento> orcamentos = new ArrayList<>();
		try{
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			Statement stmt = con.getConexao().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM orcamento");
			
			while(rs.next()){
				orcamentos.add(new Orcamento(rs.getInt("Orc_id"), rs.getInt("Orc_Data")));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return orcamentos;
        }
  
}
