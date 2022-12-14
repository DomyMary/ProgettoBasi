package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class RecensioneDAO {
	private static Connection conn = null;

	  public boolean inserisci(Recensione recensione) {
	    String query = "INSERT INTO RECENSIONE (descrizione,valutazione,data_pubblicazione, cliente) VALUES ( ?, ?, ?, ?)";
	    boolean esito = false;
	    PreparedStatement ps;
	    conn = DBManager.startConnection();
	    try {
	      ps = conn.prepareStatement(query);

	      if (recensione.getDescrizione() != null) {
	        ps.setString(1, recensione.getDescrizione());
	      } else
	        ps.setNull(1, Types.VARCHAR);
	      ps.setInt(2, recensione.getValutazione());
	      Date dataPubblicazione = new Date(recensione.getDataPublicazione().getTime());
	      ps.setDate(3, dataPubblicazione);
	      ps.setInt(4, recensione.getCliente());

	      int tmp = ps.executeUpdate();
	      if (tmp > 0)
	        esito = true;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    DBManager.closeConnection();
	    return esito;
	  }

	  public boolean cancella(Recensione recensione) {
	    String query = "DELETE FROM RECENSIONE WHERE codice_progressivo=?";
	    boolean esito = false;
	    PreparedStatement ps;
	    conn = DBManager.startConnection();
	    try {
	      ps = conn.prepareStatement(query);
	      ps.setInt(1, recensione.getCodiceProgressivo());

	      int tmp = ps.executeUpdate();
	      if (tmp > 0)
	        esito = true;
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    DBManager.closeConnection();
	    return esito;
	  }

	  public double mediaRecensioni() {
	    String query = "SELECT AVG(VALUTAZIONE) AS MEDIA_RECENSIONI FROM RECENSIONE ";
	    double res=0;
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
	  
	  }

	



