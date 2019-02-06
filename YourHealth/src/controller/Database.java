package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Database {

	public static Connection getConnection() throws Exception {
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/javaproject";
			String username = "username";
			String password = "password";

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void createTablePazienti() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE 'javaproject'.'pazienti'('id' INT UNSIGNED NOT NULL AUTO_INCREMENT,'Nome' VARCHAR(255)"
							+ " NULL,'Cognome' VARCHAR(255) NULL,'Sesso' VARCHAR(255) NULL,'LuogoNascita' VARCHAR(255)"
							+ " NULL,'DataNascita' VARCHAR(255) NULL,'Codicefiscale' VARCHAR(255) NULL,"
							+ "'Residenza' VARCHAR(255) NULL,PRIMARY KEY ('id'));");

			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createTableDottori() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS dottori"
					+ "(id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, Nome VARCHAR(255), Cognome VARCHAR(255), "
					+ "Sesso VARCHAR(255), LuogoNascita VARCHAR(255), DataNascita VARCHAR(255), "
					+ "Tesserino INT(255), Ruolo VARCHAR(255), orarioinizio VARCHAR(255), orariofine VARCHAR(255))");

			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createTableMacchinari() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS macchinari(id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
							+ "Codice VARCHAR(255), Tipo VARCHAR(255))");

			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createTableAmbulatori() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS ambulatori(id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
							+ "Codice VARCHAR(255), Abilitazione VARCHAR(255))");

			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void createTablePrestazioni() throws Exception {
		try {
			Connection conn = getConnection();
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS prestazioni(id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
							+ "CF_Paziente VARCHAR(255), ID_Dottore VARCHAR(255), Tipo VARCHAR(255), Data VARCHAR(255), "
							+ "Ora VARCHAR(255), Stato VARCHAR(255), Codice VARCHAR(255), Macchinario VARCHAR(255), "
							+ "Ambulatorio VARCHAR(255))");

			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
