package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class ClienteDAO {
	
	private static Connection conn = null;
	
	private Cliente recordToCliente(ResultSet rs) throws SQLException {
		Cliente ris = new Cliente();

		ris.setIdCliente(rs.getInt(1));
		ris.setCodiceFiscale(rs.getString(2));
		ris.setCognome(rs.getString(3));
		ris.setNome(rs.getString(4));
		ris.setDataNascita(rs.getDate(5));
		ris.setNumeroTelefono(rs.getString(6));
		ris.setSesso(rs.getString(7));
		ris.setComune(rs.getString(8));
		ris.setVia(rs.getString(9));
		ris.setNumeroCivico(rs.getString(10));
		ris.setProvincia(rs.getString(11));
		ris.setCap(rs.getInt(12));
		ris.setTipo(rs.getBoolean(13));
		ris.setDataPrenotazione(rs.getDate(14));
		ris.setDataDisdetta(rs.getDate(15));
		ris.setStatusRimborso(rs.getInt(16));
		ris.setCamera(rs.getInt(17));
		return ris;
	}
	
	public boolean insert(Cliente cliente) {
		String query = "INSERT INTO cliente(codice_fiscale,cognome,nome,data_nascita,numero_telefono,sesso,comune,via,numero_civico,provincia,cap,tipo,data_prenotazione,data_disdetta,status_rimborso,camera) VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, cliente.getCodiceFiscale());
			ps.setString(2, cliente.getCognome());
			ps.setString(3, cliente.getNome());
			Date dataNascita = new Date(cliente.getDataNascita().getTime());
			ps.setDate(4, dataNascita);
			ps.setString(5, cliente.getNumeroTelefono());
			
			if (cliente.getSesso() == null)
				ps.setNull(6, Types.CHAR);
			else
				ps.setString(6, cliente.getSesso());
			
			if (cliente.getComune() == null)
				ps.setNull(7, Types.VARCHAR);
			else
				ps.setString(7, cliente.getComune());
			
			if (cliente.getVia() == null)
				ps.setNull(8, Types.VARCHAR);
			else
				ps.setString(8, cliente.getVia());
			
			if (cliente.getNumeroCivico() == null)
				ps.setNull(9, Types.VARCHAR);
			else
				ps.setString(9, cliente.getNumeroCivico());
			
			if (cliente.getProvincia() == null)
				ps.setNull(10, Types.CHAR);
			else
				ps.setString(10, cliente.getProvincia());
			
			if (cliente.getCap() == null)
				ps.setNull(11, Types.INTEGER);
			else
				ps.setInt(11, cliente.getCap());
			
			ps.setBoolean(12, cliente.isTipo());
			
			if (cliente.getDataPrenotazione() != null) {
				Date dataPrenotazione = new Date(cliente.getDataPrenotazione().getTime());
					ps.setDate(13, dataPrenotazione);
				} else
					ps.setNull(13, Types.DATE);
			
			if (cliente.getDataDisdetta() != null) {
				Date dataDisdetta = new Date(cliente.getDataDisdetta().getTime());
					ps.setDate(14, dataDisdetta);
				} else
					ps.setNull(14, Types.DATE);
			if (cliente.getStatusRimborso() != null) {
					ps.setInt(15, cliente.getStatusRimborso());
				} else
					ps.setNull(15, Types.INTEGER);
			
			ps.setInt(16, cliente.getCamera());
				
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public Cliente get(Cliente cliente) {
		String query = "SELECT * FROM cliente WHERE (((cognome=?) AND (nome=?)) OR (codice_fiscale=?))";
		Cliente ris = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, cliente.getCognome());
			ps.setString(2,cliente.getNome());
			ps.setString(3, cliente.getCodiceFiscale());
			
			ResultSet rs = ps.executeQuery();//restituisce più tuble in generale
			if (rs.next()) {  // rs è tubla mi ristutuisce un boolean e va alla prossima tuple se mi da true senno ho finito le tuple
			ris = recordToCliente(rs);
				
			}
		} catch (SQLException e) {
			ris=null;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return ris;
	}

	//cliente disdice prenotazione
	public boolean disdetta (Cliente cliente ) { 
		String query = "UPDATE cliente Set data_disdetta=?,status_rimborso=?  WHERE id_cliente=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
		ps = conn.prepareStatement(query);
		
		if (cliente.getDataDisdetta() != null) {
			Date dataDisdetta = new Date(cliente.getDataDisdetta().getTime());
			ps.setDate(1, dataDisdetta);
		} else
			ps.setNull(1, Types.DATE);
		
		if (cliente.getStatusRimborso() != null) {
			ps.setInt(2, cliente.getStatusRimborso());
		} else
			ps.setNull(2, Types.INTEGER);
		ps.setInt(3, cliente.getIdCliente());
						
		int tmp = ps.executeUpdate();
			if (tmp >0)
				esito = true;
	} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}
