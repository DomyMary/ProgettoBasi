package it.unirc.bd2022.progettorussoaltomonte.dao;


import java.sql.Timestamp;
import java.util.Date;

public class DipendenteStandard {
	private int idStandard;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String sesso;
	private String email;
	private boolean tipoContratto;
	private int stipendio;
	private String comune;
	private String via;
	private String numeroCivico;
	private Integer cap;
	private String provincia;
	private String mansione;
	private Timestamp dataInizioTurno;
	private Timestamp dataFineTurno;

	public int getIdStandard() {
		return idStandard;
	}

	public void setIdStandard(int idStandard) {
		this.idStandard = idStandard;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isTipoContratto() {
		return tipoContratto;
	}

	public void setTipoContratto(boolean tipoContratto) {
		this.tipoContratto = tipoContratto;
	}


	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}



	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public Timestamp getDataInizioTurno() {
		return dataInizioTurno;
	}

	public void setDataInizioTurno(Timestamp dataInizioTurno) {
		this.dataInizioTurno = dataInizioTurno;
	}

	public Timestamp getDataFineTurno() {
		return dataFineTurno;
	}

	public void setDataFineTurno(Timestamp dataFineTurno) {
		this.dataFineTurno = dataFineTurno;
	}



	

}
