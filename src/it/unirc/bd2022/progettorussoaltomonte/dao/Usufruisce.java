package it.unirc.bd2022.progettorussoaltomonte.dao;



import java.sql.Timestamp;


public class Usufruisce {
	private int cliente;
	private int servizio;
	private Timestamp oraInizio;
	private Timestamp oraFine;
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getServizio() {
		return servizio;
	}
	public void setServizio(int servizio) {
		this.servizio = servizio;
	}
	public Timestamp getOraInizio() {
		return oraInizio;
	}
	public void setOraInizio(Timestamp oraInizio) {
		this.oraInizio = oraInizio;
	}
	public Timestamp getOraFine() {
		return oraFine;
	}
	public void setOraFine(Timestamp oraFine) {
		this.oraFine = oraFine;
	}
	
	

}
