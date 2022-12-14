package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class PulisceDAO {

	private static Connection conn = null;

	public boolean insert(Pulisce pulisce) {
		String query = "INSERT INTO PULISCE VALUES ( ?, ?, ?, ? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, pulisce.getDipendenteStandard());
			ps.setInt(2, pulisce.getCamera());
			ps.setTimestamp(3, pulisce.getDataFinePulizia());
			if (pulisce.getOggettiSmarriti() == null) {
				ps.setNull(4, Types.CHAR);
			} else
				ps.setString(4, pulisce.getOggettiSmarriti());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean update(Pulisce pulisce) {
		String query = "UPDATE pulisce SET dipendente_standard=?, camera=?, data_fine_pulizia = ?, oggetti_smarriti=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, pulisce.getDipendenteStandard());
			ps.setInt(2, pulisce.getCamera());

			ps.setTimestamp(3, pulisce.getDataFinePulizia());
			ps.setString(4, pulisce.getOggettiSmarriti());

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


