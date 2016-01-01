/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.projeto.mlt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
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
    
    public Orcamento(int idOrcamento, int dataOrcamento, Cliente cliente, Edificio edificio, Levantamento levantamento){
        this.idOrcamento = new SimpleIntegerProperty(idOrcamento);
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
        this.cliente = new SimpleObjectProperty<>(cliente);
        this.edficio = new SimpleObjectProperty<>(edificio);
        this.levantamento = new SimpleObjectProperty<>(levantamento);
    }
    
    public Orcamento(int dataOrcamento, Edificio edificio , Cliente cliente, Levantamento levantamento){
        this.dataOrcamento = new SimpleIntegerProperty(dataOrcamento);
        this.edficio = new SimpleObjectProperty<>(edificio);
        this.cliente = new SimpleObjectProperty<>(cliente);
        this.levantamento = new SimpleObjectProperty<>(levantamento);
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

    @Override
    public String toString() {
        return "Orcamento{" + "idOrcamento=" + idOrcamento + ", dataOrcamento=" + dataOrcamento + ", cliente=" + cliente + ", edficio=" + edficio + ", levantamento=" + levantamento + '}';
    }
    
    
	public void inserirNovoOrcamento(){
		try {
			ConexaoBaseDados con = ConexaoBaseDados.conectar();
			String insertStatement = "INSERT INTO orcamento(Orc_data)VALUES(?)";
			Connection conexao = con.getConexao();
			PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
			
			ps.setInt(1, dataOrcamento.getValue());
                        //ps.setInt(2, edficio.getValue().getIdEdificio().getValue());
                        //ps.setInt(3, cliente.getValue().getIdCliente().getValue());
                        //ps.setInt(4, levantamento.getValue().getIdLevantamento().getValue());
			
			ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
    
    
    
    /*
    
    public void inserirOrcamento(){
        try {
            ConexaoBaseDados con = ConexaoBaseDados.conectar();
            String insertStatement = "INSERT INTO orcamento(Orc_Data,Orc_Edif_id,Orc_Cliente_id,Orc_Lev_id) VALUES(?,?,?,?)";
            //String insertStatement = "INSERT INTO orcamento(Orc_Data) VALUES(?)";
            Connection conexao = con.getConexao();
            PreparedStatement ps = (PreparedStatement) conexao.prepareStatement(insertStatement);
            
            ps.setInt(1, dataOrcamento.getValue());
            ps.setInt(2, edficio.getValue().getIdEdificio().getValue());
            ps.setInt(3, cliente.getValue().getIdCliente().getValue());
            ps.setInt(4, levantamento.getValue().getIdLevantamento().getValue());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
   
    
}
