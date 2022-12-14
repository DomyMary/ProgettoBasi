package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Timestamp;



public class HaPartecipato {
	private int cliente;
	private int evento;
	private Timestamp dataPartecipato;
	
	
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getEvento() {
		return evento;
	}
	public void setEvento(int evento) {
		this.evento = evento;
	}
	public Timestamp getDataPartecipato() {
		return dataPartecipato;
	}
	public void setDataPartecipato(Timestamp dataPartecipato) {
		this.dataPartecipato = dataPartecipato;
	}
	
	
	
	

}
