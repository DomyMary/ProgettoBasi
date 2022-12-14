package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class SoggiornaDAO {

	private static Connection conn = null;
	
	private Soggiorna recordToSoggiorna(ResultSet rs) throws SQLException {
       Soggiorna ris = new Soggiorna();

		ris.setCliente(rs.getInt(1));
		ris.setCamera(rs.getInt(2));
		ris.setDataCheckIn(rs.getTimestamp(3));

		return ris;
	}

	public boolean insert(Soggiorna soggiorna) {
		String query = "INSERT INTO soggiorna VALUES ( ?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, soggiorna.getCliente());
			ps.setInt(2, soggiorna.getCamera());
			ps.setTimestamp(3, soggiorna.getDataCheckIn());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	public Vector<Soggiorna> getAll() {
		String query = "SELECT * FROM soggiorna ";
		Vector<Soggiorna> res =new Vector<Soggiorna>(); 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();  // esegue query, restituisce più tuble in generale
			while  (rs.next()) { 
            Soggiorna soggiorna = recordToSoggiorna(rs);
			res.add(soggiorna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public boolean delete(Soggiorna soggiorna) {
		String query = "DELETE FROM soggiorna WHERE cliente=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, soggiorna.getCliente());

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
