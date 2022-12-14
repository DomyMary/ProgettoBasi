package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.util.Date;


public class Cliente {
	
	private int idCliente;
	private String codiceFiscale;
	private String cognome;
	private String nome;
	private Date dataNascita;
    private String numeroTelefono;
    private String sesso;
    private String comune;
    private String via;
    private String numeroCivico;
    private String provincia;
    private Integer cap;
    private boolean tipo;// true=normale, false=VIP;
    private Date dataPrenotazione;
    private Date  dataDisdetta;
    private Integer statusRimborso;// 0--> Non necessario, 1--> effettuato, 2-->in attesa, 3-->non effettuato
    private Integer camera;
	
   

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getCodiceFiscale() {
		return codiceFiscale;
	}


	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}


	public String getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	public String getSesso() {
		return sesso;
	}


	public void setSesso(String sesso) {
		this.sesso = sesso;
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


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public Integer getCap() {
		return cap;
	}


	public void setCap(Integer cap) {
		this.cap = cap;
	}


	public boolean isTipo() {
		return tipo;
	}


	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}




	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}


	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}


	public Date getDataDisdetta() {
		return dataDisdetta;
	}


	public void setDataDisdetta(Date dataDisdetta) {
		this.dataDisdetta = dataDisdetta;
	}


	public Integer getStatusRimborso() {
		return statusRimborso;
	}


	public void setStatusRimborso(Integer statusRimborso) {
		this.statusRimborso = statusRimborso;
	}


	public Integer getCamera() {
		return camera;
	}


	public void setCamera(Integer camera) {
		this.camera = camera;
	}


	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", codiceFiscale=" + codiceFiscale + ", cognome=" + cognome
				+ ", nome=" + nome + ", dataNascita=" + dataNascita + ", numeroTelefono=" + numeroTelefono + ", sesso="
				+ sesso + ", comune=" + comune + ", via=" + via + ", numeroCivico=" + numeroCivico + ", provincia="
				+ provincia + ", cap=" + cap + ", tipo=" + tipo + ", dataPrenotazione=" + dataPrenotazione
				+ ", dataDisdetta=" + dataDisdetta + ", statusRimborso=" + statusRimborso + ", camera=" + camera + "]";
	}
    
    
    
}
