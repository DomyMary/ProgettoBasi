package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Timestamp;


public class Pulisce {
	private int dipendenteStandard;
	private int camera;
	private Timestamp dataFinePulizia;
	private String oggettiSmarriti;
	
	
	public int getDipendenteStandard() {
		return dipendenteStandard;
	}
	public void setDipendenteStandard(int dipendenteStandard) {
		this.dipendenteStandard = dipendenteStandard;
	}
	public int getCamera() {
		return camera;
	}
	public void setCamera(int camera) {
		this.camera = camera;
	}
	
	
	public Timestamp getDataFinePulizia() {
		return dataFinePulizia;
	}
	public void setDataFinePulizia(Timestamp dataFinePulizia) {
		this.dataFinePulizia = dataFinePulizia;
	}
	public String getOggettiSmarriti() {
		return oggettiSmarriti;
	}
	public void setOggettiSmarriti(String oggettiSmarriti) {
		this.oggettiSmarriti = oggettiSmarriti;
	}
	

}
