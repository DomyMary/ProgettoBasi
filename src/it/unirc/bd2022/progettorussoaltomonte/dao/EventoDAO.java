package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class EventoDAO {
	private static Connection conn = null;
	
	private Evento recordToEvento(ResultSet rs) throws SQLException {
		Evento ris = new Evento();

		ris.setIdEvento(rs.getInt(1));
		ris.setNome(rs.getString(2));
		ris.setTipo(rs.getString(3));
		ris.setDataInizio(rs.getTimestamp(4));
		ris.setDataFine(rs.getTimestamp(5));
		ris.setDipendenteManeger(rs.getInt(6));

		return ris;
	}
	
	
	public boolean insert(Evento evento) {
		String query = "INSERT INTO evento(nome,tipo,data_inizio,data_fine,dipendente_manager) VALUES ( ?,?,?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, evento.getNome());
			ps.setString(2, evento.getTipo());
			ps.setTimestamp(3, evento.getDataInizio());
			if (evento.getDataFine() == null)
				ps.setNull(4, Types.TIMESTAMP);
			else {
				ps.setTimestamp(5, evento.getDataFine());
				}
			
			ps.setInt(6, evento.getDipendenteManeger());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	
	public boolean aggiorna (Evento evento ) { 
		String query = "UPDATE evento Set nome=?, tipo=?, data_inizio=?,data_fine=?, dipendente_manager=? WHERE id_evento=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
		ps = conn.prepareStatement(query);
		
		ps.setString(1, evento.getNome());
		ps.setString(2, evento.getTipo());
		ps.setTimestamp(3, evento.getDataInizio());

			if (evento.getDataFine() != null) {
				ps.setTimestamp(4, evento.getDataFine());
			} else
				ps.setNull(4, Types.TIMESTAMP);
			
			ps.setInt(5,evento.getDipendenteManeger());
			ps.setInt(6, evento.getIdEvento());
						
		int tmp = ps.executeUpdate();
			if (tmp >0)
				esito = true;
	} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	

//ricerca evento conoscendo nome e data inizio
public Evento get(Evento evento) {
	String query = "SELECT * FROM EVENTO WHERE (nome=?) AND (data_inizio=?)";
	Evento res = null;
	PreparedStatement ps;
	conn = DBManager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		
		ps.setString(1, evento.getNome());
		ps.setTimestamp(2,evento.getDataInizio());
		
		ResultSet rs = ps.executeQuery();//restituisce più tuble in generale
		if (rs.next()) {  // rs è tubla //mi ristutuisced un boolean e va alla prossima tuple se mi da true senno ho finito le tuple
		res = recordToEvento(rs);
			
		}
	} catch (SQLException e) {
		res=null;
		e.printStackTrace();
	}
	DBManager.closeConnection();
	return res;
}
//publicazione del calendario degli eventi
public Vector<Evento> getAll() {
	String query = "SELECT * FROM evento";
	Vector<Evento> res =new Vector<Evento>(); 
	PreparedStatement ps;
	conn = DBManager.startConnection();
	try {
		ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();  // esegue query, restituisce più tuble in generale
		while  (rs.next()) { 
        Evento evento = recordToEvento(rs);
		res.add(evento);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	DBManager.closeConnection();
	System.out.println(res);
	return res;
}

public boolean delete(Evento evento) {
	String query = "DELETE FROM evento WHERE id_evento=?";
	boolean esito = false;
	PreparedStatement ps;
	conn = DBManager.startConnection();
	try {
		ps = conn.prepareStatement(query);

		ps.setInt(1, evento.getIdEvento());

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

