package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class ServizioDAO {
	private static Connection conn = null;


	public boolean inserisci(Servizio servizio) {
		String query = "INSERT INTO SERVIZIO VALUES ( ?, ?, ?, ?, ?,?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, servizio.getCodice());
			ps.setInt(2, servizio.getTariffa());
			ps.setInt(3, servizio.getNumeroLavoratori());
			ps.setString(4, servizio.getNome());
			ps.setInt(5, servizio.getPostiDisponibili());
			ps.setInt(6, servizio.getDipendenteManager());

			int tmp = ps.executeUpdate();

			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean cancella(Servizio servizio) {
		String query = "DELETE FROM SERVIZIO WHERE codice=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, servizio.getCodice());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean update(Servizio servizio) {
		String query = "UPDATE servizio SET codice=?, tariffa=?, numero_lavoratori=?, nome=?, posti_disponibili=?, dipendente_manager=? ";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, servizio.getCodice());
			ps.setInt(2, servizio.getTariffa());
			ps.setInt(3, servizio.getNumeroLavoratori());
			ps.setString(4, servizio.getNome());
			ps.setInt(5, servizio.getPostiDisponibili());
			ps.setInt(6, servizio.getDipendenteManager());

			int tmp = ps.executeUpdate();

			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean ricercaPosti(Servizio servizio) {
		String query = "SELECT posti_disponibili FROM servizio where codice=?;";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, servizio.getPostiDisponibili());
			ps.setInt(2, servizio.getCodice());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	
}

