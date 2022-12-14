package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class HaSoggiornatoDAO {
	private static Connection conn = null;
	
	private HaSoggiornato recordToHaSoggiornato(ResultSet rs) throws SQLException {
		HaSoggiornato ris = new HaSoggiornato();

		ris.setCliente(rs.getInt(1));
		ris.setCamera(rs.getInt(2));
        ris.setDataCheckIn(rs.getTimestamp(3));
        ris.setDataCheckOut(rs.getTimestamp(4));
		
        return ris;
	}
	
	public boolean insert(HaSoggiornato hasoggiornato) {
		String query = "INSERT INTO ha_soggiornato VALUES ( ?,?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, hasoggiornato.getCliente());
			ps.setInt(2, hasoggiornato.getCamera());
			ps.setTimestamp(3, hasoggiornato.getDataCheckIn());
			ps.setTimestamp(4, hasoggiornato.getDataCheckOut());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public Vector<HaSoggiornato> ListaClientiFrequenti() {
		String query = "SElECT count(*) ,concat(C.nome,\" \", C.cognome)AS cliente FROM ha_soggiornato ha JOIN cliente c ON ha.cliente=c.id_cliente GROUP BY cliente HAVING COUNT(*)>1 ORDER BY COUNT(*) DESC";
		Vector<HaSoggiornato> res =new Vector<HaSoggiornato>(); 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery(); 
			while  (rs.next()) { 
            HaSoggiornato hasoggiornato = recordToHaSoggiornato(rs);
			res.add(hasoggiornato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}

}
