package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class DipendenteStandardDAO {
	private static Connection conn = null;

	private DipendenteStandard recordToStandard(ResultSet rs) throws SQLException {
		DipendenteStandard ris = new DipendenteStandard();

		ris.setIdStandard(rs.getInt(1));
		ris.setCodiceFiscale(rs.getString(2));
		ris.setNome(rs.getString(3));
		ris.setCognome(rs.getString(4));
		ris.setDataNascita(rs.getDate(5));
		ris.setSesso(rs.getString(6));
		ris.setEmail(rs.getString(7));
		ris.setTipoContratto(rs.getBoolean(8));
		ris.setStipendio(rs.getInt(9));
		ris.setComune(rs.getString(10));
		ris.setVia(rs.getString(11));
		ris.setNumeroCivico(rs.getString(12));
		ris.setCap(rs.getInt(13));
		ris.setProvincia(rs.getString(14));
		ris.setMansione(rs.getString(15));
		ris.setDataInizioTurno(rs.getTimestamp(16));
		ris.setDataFineTurno(rs.getTimestamp(17));

		return ris;
	}

	public boolean insert(DipendenteStandard standard) {
		String query = "INSERT INTO DIPENDENTE_STANDARD (codice_fiscale, nome, cognome, data_nascita, sesso, email, tipo_contratto, stipendio, comune, via, numero_civico, cap, provincia, mansione, data_inizio_turno, data_fine_turno) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? ,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, standard.getCodiceFiscale());
			ps.setString(2, standard.getNome());
			ps.setString(3, standard.getCognome());
			Date dataNascita = new Date(standard.getDataNascita().getTime());
			ps.setDate(4, dataNascita);
			if (standard.getSesso() == null) {
				ps.setNull(5, Types.CHAR);
			} else
				ps.setString(5, standard.getSesso());

			if (standard.getEmail() == null) {
				ps.setNull(6, Types.VARCHAR);
			} else
				ps.setString(6, standard.getEmail());
			ps.setBoolean(7, standard.isTipoContratto());
			ps.setInt(8, standard.getStipendio());
			if (standard.getComune() == null) {
				ps.setNull(9, Types.VARCHAR);
			} else
				ps.setString(9, standard.getComune());
			if (standard.getVia() == null) {
				ps.setNull(10, Types.VARCHAR);
			} else
				ps.setString(10, standard.getVia());
			if (standard.getNumeroCivico() == null) {
				ps.setNull(11, Types.VARCHAR);
			} else
				ps.setString(11, standard.getNumeroCivico());
			if (standard.getCap() == null) {
				ps.setNull(12, Types.INTEGER);
			} else
				ps.setInt(12, standard.getCap());
			if (standard.getProvincia() == null) {
				ps.setNull(13, Types.CHAR);
			} else
				ps.setString(13, standard.getProvincia());

			ps.setString(14, standard.getMansione());

			ps.setTimestamp(15, standard.getDataInizioTurno());

			ps.setTimestamp(16, standard.getDataFineTurno());

			int tmp = ps.executeUpdate();

			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public DipendenteStandard ricercaBreve(DipendenteStandard standard) {
		String query = "SELECT * FROM DIPENDENTE_MANAGER WHERE (nome= ?) AND (cognome=?)";
		DipendenteStandard ris = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, standard.getNome());
			ps.setString(2, standard.getCognome());

			ResultSet rs = ps.executeQuery();// restituisce più tuble in generale
			if (rs.next()) { // rs è tubla mi ristutuisce un boolean e va alla prossima tuple se mi da true
								// senno ho finito le tuple
				ris = recordToStandard(rs);

			}
		} catch (SQLException e) {
			ris = null;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return ris;
	}

	public boolean update(DipendenteStandard standard) {
		String query = "UPDATE dipendente_standard SET  codice_fiscale=?, nome=?, cognome=?, data_nascita=?, sesso=?, email=?, tipo_contratto=?, stipendio=?, comune=?, via=?, numero_civico=?, cap=?, provincia=?, mansione=?, dataInizioTurno=?, data_fine_turno=?, WHERE id_standard=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, standard.getCodiceFiscale());
			ps.setString(2, standard.getNome());
			ps.setString(3, standard.getCognome());
			Date dataNascita = new Date(standard.getDataNascita().getTime());
			ps.setDate(4, dataNascita);
			if (standard.getSesso() == null) {
				ps.setNull(5, Types.CHAR);
			} else
				ps.setString(5, standard.getSesso());

			if (standard.getEmail() == null) {
				ps.setNull(6, Types.VARCHAR);
			} else
				ps.setString(6, standard.getEmail());
			ps.setBoolean(7, standard.isTipoContratto());
			ps.setInt(8, standard.getStipendio());
			if (standard.getComune() == null) {
				ps.setNull(9, Types.VARCHAR);
			} else
				ps.setString(9, standard.getComune());
			if (standard.getVia() == null) {
				ps.setNull(10, Types.VARCHAR);
			} else
				ps.setString(10, standard.getVia());
			if (standard.getNumeroCivico() == null) {
				ps.setNull(11, Types.VARCHAR);
			} else
				ps.setString(11, standard.getNumeroCivico());
			if (standard.getCap() == null) {
				ps.setNull(12, Types.INTEGER);
			} else
				ps.setInt(12, standard.getCap());
			if (standard.getProvincia() == null) {
				ps.setNull(13, Types.CHAR);
			} else
				ps.setString(13, standard.getProvincia());

			ps.setString(14, standard.getMansione());
			ps.setTimestamp(16, standard.getDataInizioTurno());

			ps.setTimestamp(17, standard.getDataFineTurno());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public boolean cancella(DipendenteStandard standard) {
		String query = "DELETE FROM DIPENDENTE_STANDARD WHERE id_standard=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, standard.getIdStandard());

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

