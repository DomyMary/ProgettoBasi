package it.unirc.bd2022.progettorussoaltomonte.dao;

public class Servizio {
	private int codice;

	private int tariffa;
	private int numeroLavoratori;
	private String nome;
	private int postiDisponibili;
	private int dipendenteManager;
	
	
		public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public int getTariffa() {
		return tariffa;
	}
	public void setTariffa(int tariffa) {
		this.tariffa = tariffa;
	}
	public int getNumeroLavoratori() {
		return numeroLavoratori;
	}
	public void setNumeroLavoratori(int numeroLavoratori) {
		this.numeroLavoratori = numeroLavoratori;
	}
	
	@Override
	public String toString() {
		return "Servizio [codice=" + codice + ", tariffa=" + tariffa + ", numeroLavoratori=" + numeroLavoratori
				+ ", nome=" + nome + ", postiDisponibili=" + postiDisponibili + ", dipendenteManager="
				+ dipendenteManager + "]";
	}
	public int getPostiDisponibili() {
		return postiDisponibili;
	}
	public void setPostiDisponibili(int postiDisponibili) {
		this.postiDisponibili = postiDisponibili;
	}
	public int getDipendenteManager() {
		return dipendenteManager;
	}
	public void setDipendenteManager(int dipendenteManager) {
		this.dipendenteManager = dipendenteManager;
	}

}
