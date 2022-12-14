package it.unirc.bd2022.progettorussoaltomonte.dao;


import java.util.Date;

public class Recensione {
	
	private int codiceProgressivo;
	private String descrizione;
	private int valutazione;
	private Date dataPublicazione;
	private int cliente;
	
	
	
	public int getCodiceProgressivo() {
		return codiceProgressivo;
	}
	public void setCodiceProgressivo(int codiceProgressivo) {
		this.codiceProgressivo = codiceProgressivo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getValutazione() {
		return valutazione;
	}
	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	
	public Date getDataPublicazione() {
		return dataPublicazione;
	}
	public void setDataPublicazione(Date dataPublicazione) {
		this.dataPublicazione = dataPublicazione;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	
	
	

}
