package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class UsufruisceDAO {
	  private static Connection conn = null;


	  public boolean insert(Usufruisce usufruisce) {
	    String query = "INSERT INTO usufruisce VALUES ( ?, ?, ?, ? )";
	    boolean esito = false;
	    PreparedStatement ps;
	    conn = DBManager.startConnection();
	    try {
	      ps = conn.prepareStatement(query);

	      ps.setInt(1, usufruisce.getCliente());
	      ps.setInt(2, usufruisce.getServizio());
	      ps.setTimestamp(3, usufruisce.getOraInizio());
	      ps.setTimestamp(4, usufruisce.getOraFine());

	      int tmp = ps.executeUpdate();
	      if (tmp > 0)
	        esito = true;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    DBManager.closeConnection();
	    return esito;
	  }

	  public String ServizoUtilizzato() {
			String query = "SELECT nome,COUNT(*) FROM USUFRUISCE JOIN SERVIZIO ON SERVIZIO=CODICE GROUP BY SERVIZIO ORDER BY COUNT(*) LIMIT 1";
			String res="null";
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);


				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					res = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.closeConnection();
			System.out.println(res);
			return res;
		}
	  
	  
		}





