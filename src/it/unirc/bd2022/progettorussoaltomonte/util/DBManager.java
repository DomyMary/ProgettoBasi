package it.unirc.bd2022.progettorussoaltomonte.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection conn = null;

	private static final String DbDriver = "com.mysql.cj.jdbc.Driver"; //contiene le istruzioni per dialogare con MySQL
	private static final String DbURL = "jdbc:mysql://localhost:3306/progetto_altomonte_russo?useSSL=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "root";

	private DBManager() {
	}

	/**
	 * Metodo che restituisce true se la connessione e' aperta.
	 */
	public static boolean isOpen() {
		// if (conn == null)
		// 		return false;
		// else
		// 		return true;
		return (conn != null);
	}

	public static Connection startConnection() {
		if (isOpen())
			return conn;
		try {
			Class.forName(DbDriver);// Carica il Driver del DBMS
			conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	public static boolean closeConnection() {
		if (!isOpen())
			return true;
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}


