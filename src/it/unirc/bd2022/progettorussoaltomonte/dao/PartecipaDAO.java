package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class PartecipaDAO {
	private static Connection conn = null;

	public boolean insert(Partecipa Partecipa) {
		String query = "INSERT INTO Partecipato VALUES ( ?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, Partecipa.getCliente());
			ps.setInt(2, Partecipa.getEvento());
				
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean delete(Partecipa partecipa) {
		String query = "DELETE FROM partecipa WHERE evento=? ";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, partecipa.getEvento());

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
