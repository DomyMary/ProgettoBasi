package it.unirc.bd2022.progettorussoaltomonte.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;

import it.unirc.bd2022.progettorussoaltomonte.util.DBManager;



public class CameraDAO {
	private static Connection conn = null;
	
	private Camera recordToCamera(ResultSet rs) throws SQLException {
		Camera ris = new Camera();

		ris.setIdCamera(rs.getInt(1));
		ris.setNumeroCamera(rs.getInt(2));
		ris.setCodicePiano(rs.getString(3));
		ris.setTipologia(rs.getInt(4));
		ris.setDisponibilità(rs.getBoolean(5));
		ris.setOptional(rs.getString(6));

		return ris;
	}
	
	public boolean insert(Camera camera) {
		String query = "INSERT INTO CAMERA(numero_camera,codice_piano,tipologia,disponibilità,optional) VALUES ( ?,?,?,?,? )";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, camera.getNumeroCamera());
			ps.setString(2, camera.getCodicePiano());
			ps.setInt(3, camera.getTipologia());
			ps.setBoolean(4, camera.isDisponibilità());
			if (camera.getOptional() == null)
				ps.setNull(5, Types.VARCHAR);
			else
				ps.setString(5, camera.getOptional());
			
			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean delete(Camera camera) {
		String query = "DELETE FROM camera WHERE id_camera=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, camera.getIdCamera());

			int tmp = ps.executeUpdate();
			if (tmp > 0)
				esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	
	public boolean aggiorna (Camera camera ) { 
		String query = "UPDATE camera Set numero_camera=?, codice_piano=?, tipologia=?,disponibilità=?, optional=? WHERE id_camera=?";
		boolean esito = false;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, camera.getNumeroCamera());
		ps.setString(2, camera.getCodicePiano());
		ps.setInt(3, camera.getTipologia());
		ps.setBoolean(4, camera.isDisponibilità());

			if (camera.getOptional() != null) {
				ps.setString(5, camera.getOptional());
			} else
				ps.setNull(5, Types.VARCHAR);
			
			ps.setInt(6, camera.getIdCamera());
						
		int tmp = ps.executeUpdate();
			if (tmp >0)
				esito = true;
	} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	public Camera get(Integer key) {
		String query = "SELECT * FROM reparto WHERE (id_reparto = ?)";
		Camera ris = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);

			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ris = recordToCamera(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return ris;
	}
	
	public Vector<Camera> getAll() {
		String query = "SELECT * FROM CAMERA WHERE disponibilità=1";
		Vector<Camera> res =new Vector<Camera>(); 
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();  // esegue query, restituisce più tuble in generale
			while  (rs.next()) { 
            Camera camera = recordToCamera(rs);
			res.add(camera);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public Camera get(Camera camera) {
		String query = "SELECT * FROM CAMERA WHERE (numero_camera=?) AND (tipologia=?)";
		Camera res = null;
		PreparedStatement ps;
		conn = DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, camera.getNumeroCamera());
			ps.setInt(2,camera.getTipologia());
			
			ResultSet rs = ps.executeQuery();//restituisce più tuble in generale
			if (rs.next()) {  // rs è tubla //mi ristutuisced un boolean e va alla prossima tuple se mi da true senno ho finito le tuple
			res = recordToCamera(rs);
				
			}
		} catch (SQLException e) {
			res=null;
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
		
	
	


}
