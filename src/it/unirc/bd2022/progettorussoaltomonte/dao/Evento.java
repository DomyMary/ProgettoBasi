package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Timestamp;

public class Evento {
	private int idEvento;
	private String nome;
	private String tipo;
	private Timestamp dataInizio;
	private Timestamp dataFine;
	private int dipendenteManeger;

	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public Timestamp getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Timestamp dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Timestamp getDataFine() {
		return dataFine;
	}
	public void setDataFine(Timestamp dataFine) {
		this.dataFine = dataFine;
	}
	public int getDipendenteManeger() {
		return dipendenteManeger;
	}
	public void setDipendenteManeger(int dipendenteManeger) {
		this.dipendenteManeger = dipendenteManeger;
	}
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nome=" + nome + ", tipo=" + tipo + ", dataInizio=" + dataInizio
				+ ", dataFine=" + dataFine + ", dipendenteManeger=" + dipendenteManeger + "]";
	}
	

	
	

}
