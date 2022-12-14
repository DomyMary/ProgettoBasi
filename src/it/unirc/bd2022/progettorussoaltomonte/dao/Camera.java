package it.unirc.bd2022.progettorussoaltomonte.dao;

public class Camera {
	
	private int idCamera;
	private int numeroCamera;
	private String codicePiano;
	private int tipologia;//0--> singola,1-->matrimoniale,2--->tripla,3-->suite
	private boolean disponibilità;//true=disponibile,false=non disponibile //1=true
	private String optional;



	public int getIdCamera() {
		return idCamera;
	}


	public void setIdCamera(int idCamera) {
		this.idCamera = idCamera;
	}


	public int getNumeroCamera() {
		return numeroCamera;
	}


	public void setNumeroCamera(int numeroCamera) {
		this.numeroCamera = numeroCamera;
	}


	public String getCodicePiano() {
		return codicePiano;
	}


	public void setCodicePiano(String codicePiano) {
		this.codicePiano = codicePiano;
	}


	public int getTipologia() {
		return tipologia;
	}


	public void setTipologia(int tipologia) {
		this.tipologia = tipologia;
	}


	public boolean isDisponibilità() {
		return disponibilità;
	}


	public void setDisponibilità(boolean disponibilità) {
		this.disponibilità = disponibilità;
	}


	public String getOptional() {
		return optional;
	}


	public void setOptional(String optional) {
		this.optional = optional;
	}


	@Override
	public String toString() {
		return "Camera [idCamera=" + idCamera + ", numeroCamera=" + numeroCamera + ", codicePiano=" + codicePiano
				+ ", tipologia=" + tipologia + ", disponibilità=" + disponibilità + ", optional=" + optional + "]";
	}
	
	
	

}
