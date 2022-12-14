package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Timestamp;



public class HaSoggiornato {
	private int cliente;
	private int camera;
	private Timestamp dataCheckIn;
	private Timestamp dataCheckOut;
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	  
	public Timestamp getDataCheckIn() {
		return dataCheckIn;
	}
	public Timestamp getDataCheckOut() {
		return dataCheckOut;
	}
	public void setDataCheckOut(Timestamp dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}
	public void setDataCheckIn(Timestamp dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	@Override
	public String toString() {
		return "HaSoggiornato [cliente=" + cliente + ", camera=" + camera + ", dataCheckIn=" + dataCheckIn
				+ ", dataCheckOut=" + dataCheckOut + "]";
	}
	
	
	
	

}
