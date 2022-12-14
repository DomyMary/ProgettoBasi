package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class HaPartecipatoDAO {
	private static Connection conn = null;
	
	public boolean insert(HaPartecipato haPartecipato) {
		String query = "INSERT INTO HaPartecipato VALUES ( ?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, haPartecipato.getCliente());
			ps.setInt(2, haPartecipato.getEvento());
			ps.setTimestamp(3, haPartecipato.getDataPartecipato());
				
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public int numPersone(HaPartecipato haPartecipato) {
		String query = "SELECT COUNT(*) FROM ha_partecipato WHERE EVENTO=?";
		int res =0; 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1,haPartecipato.getEvento() );
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		System.out.println(res);
		return res;
	}
	public int getTotEventi() {
		String query = "SELECT COUNT(*) FROM ha_partecipato";
		int res =0; 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		System.out.println(res);
		return res;
	}
	public  int percentualePersone(HaPartecipato haPartecipato) {
		String query = "SELECT COUNT(CLIENTE)*100 FROM HA_PARTECIPATO WHERE EVENTO=?";
		int res =0; 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1,haPartecipato.getEvento() );
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
  
	
}
