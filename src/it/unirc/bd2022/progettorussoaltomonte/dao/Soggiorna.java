package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Timestamp;


public class Soggiorna {
	private int cliente;
	private int camera;
    private Timestamp dataCheckIn;
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
	public void setDataCheckIn(Timestamp dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}
	
	
    
    
   
}
