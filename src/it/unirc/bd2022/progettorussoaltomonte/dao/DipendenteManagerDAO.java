package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;

public class DipendenteManagerDAO {
		private static Connection conn = null;



		public boolean insert(DipendenteManager manager) {
			String query = "INSERT INTO DIPENDENTE_MANAGER (codice_fiscale, nome, cognome, data_nascita, sesso, email, tipo_contratto, stipendio, comune, via, numero_civico, cap, provincia)  VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
			boolean esito = false;
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);

				ps.setString(1, manager.getCodiceFiscale());
				ps.setString(2, manager.getNome());
				ps.setString(3, manager.getCognome());
				Date dataNascita = new Date(manager.getDataNascita().getTime());
				ps.setDate(4, dataNascita);
				if (manager.getSesso() == null) {
					ps.setNull(5, Types.CHAR);
				} else
					ps.setString(5, manager.getSesso());

				if (manager.getEmail() == null) {
					ps.setNull(6, Types.VARCHAR);
				} else
					ps.setString(6, manager.getEmail());
				ps.setBoolean(7, manager.getTipoContratto());
				ps.setInt(8, manager.getStipendio());
				if (manager.getComune() == null) {
					ps.setNull(9, Types.VARCHAR);
				} else
					ps.setString(9, manager.getComune());
				if (manager.getVia() == null) {
					ps.setNull(10, Types.VARCHAR);
				} else
					ps.setString(10, manager.getVia());
				if (manager.getNumeroCivico() == null) {
					ps.setNull(11, Types.VARCHAR);
				} else
					ps.setString(11, manager.getNumeroCivico());
				if (manager.getCap() == null) {
					ps.setNull(12, Types.VARCHAR);
				} else
					ps.setInt(12, manager.getCap());
				if (manager.getProvincia() == null) {
					ps.setNull(13, Types.CHAR);
				} else
					ps.setString(13, manager.getProvincia());

				int tmp = ps.executeUpdate();

				if (tmp > 0)
					esito = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.closeConnection();
			return esito;
		}

		public boolean ricercaBreve(DipendenteManager manager) {
			String query = "SELECT * FROM DIPENDENTE_MANAGER WHERE (nome= ?) AND (cognome=?)";
			boolean esito = false;
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);

				ps.setString(1, manager.getNome());
				ps.setString(2, manager.getCognome());

				int tmp = ps.executeUpdate();

				if (tmp > 0)
					esito = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.closeConnection();
			return esito;
		}

		public boolean update(DipendenteManager manager) {
			String query = "UPDATE dipendente_manager SET codice_fiscale=?, nome=?, cognome=?, data_nascita=?, sesso=?, email=?, tipo_contratto=?, stipendio=?, comune=?, via=?, numero_civico=?, cap=?, provincia=? WHERE id_manager=?";
			boolean esito = false;
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);

				ps.setString(1, manager.getCodiceFiscale());
				ps.setString(2, manager.getNome());
				ps.setString(3, manager.getCognome());
				Date dataNascita = new Date(manager.getDataNascita().getTime());
				ps.setDate(4, dataNascita);
				if (manager.getSesso() == null) {
					ps.setNull(5, Types.CHAR);
				} else
					ps.setString(5, manager.getSesso());

				if (manager.getEmail() == null) {
					ps.setNull(6, Types.VARCHAR);
				} else
					ps.setString(6, manager.getEmail());
				ps.setBoolean(7, manager.getTipoContratto());
				ps.setInt(8, manager.getStipendio());
				if (manager.getComune() == null) {
					ps.setNull(9, Types.VARCHAR);
				} else
					ps.setString(9, manager.getComune());
				if (manager.getVia() == null) {
					ps.setNull(10, Types.VARCHAR);
				} else
					ps.setString(10, manager.getVia());
				if (manager.getNumeroCivico() == null) {
					ps.setNull(11, Types.VARCHAR);
				} else
					ps.setString(11, manager.getNumeroCivico());
				if (manager.getCap() == null) {
					ps.setNull(12, Types.INTEGER);
				} else
					ps.setInt(12, manager.getCap());
				if (manager.getProvincia() == null) {
					ps.setNull(13, Types.CHAR);
				} else
					ps.setString(13, manager.getProvincia());
				ps.setInt(14, manager.getIdManager());

				int tmp = ps.executeUpdate();

				if (tmp > 0)
					esito = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.closeConnection();
			return esito;
		}

		public boolean cancella(DipendenteManager manager) {
			String query = "DELETE FROM DIPENDENTE_MANAGER WHERE id_manager=?";
			boolean esito = false;
			PreparedStatement ps;
			conn = DBManager.startConnection();
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, manager.getIdManager());

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
// da implementare
