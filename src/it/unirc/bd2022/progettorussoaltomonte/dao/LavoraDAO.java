package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class LavoraDAO {

	private static Connection conn = null;

	public boolean inserisci(Lavora lavora) {
		String query = "INSERT INTO * VALUES ( ?, ?)";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, lavora.getDipendenteStandard());
			ps.setInt(4, lavora.getServizio());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean update(Lavora lavora) {
		String query = "UPDATE lavora SET dipendente_standard=?, servizio=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, lavora.getDipendenteStandard());
			ps.setInt(2, lavora.getServizio());

			int tmp = ps.executeUpdate();

			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean cancella(Lavora lavora) {
		String query = "DELETE FROM LAVORA WHERE dipendente_standard=?, servizio=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, lavora.getDipendenteStandard());
			ps.setInt(2, lavora.getServizio());

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

