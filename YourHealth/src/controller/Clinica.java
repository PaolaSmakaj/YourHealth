package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Ambulatorio;
import model.AmbulatorioImpl;
import model.Dottore;
import model.DottoreImpl;
import model.Macchinario;
import model.MacchinarioImpl;
import model.Paziente;
import model.PazienteImpl;
import model.Prestazione;
import model.PrestazioneImpl;
import util.Enums;
import util.Enums.Stato;

public class Clinica {

	public static Connection getConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/javaproject?serverTimezone=UTC";
			String username = "username";
			String password = "password";

			Connection conn = DriverManager.getConnection(url, username, password);
			if(conn != null) {
				System.out.println("Connected");
			} else {
				System.out.println("Not Connected");
			}
			return conn;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void addPaziente(Paziente P) throws Exception {
		try {
			Connection con = getConnection();
			System.out.println("Nome Paziente: " + P.getNome());
			System.out.println("Cognome Paziente: " + P.getCognome());
			System.out.println("Sesso Paziente: " + P.getSesso());
			System.out.println("Luogo Nascita Paziente: " + P.getLuogoNascita());
			System.out.println("Data Nascita Paziente: " + P.getDataNascita());
			System.out.println("Codice Fiscale Paziente: " + P.getCodicefiscale());
			System.out.println("Residenza Paziente: " + P.getResidenza());
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO pazienti (Nome,Cognome,Sesso,LuogoNascita,DataNascita,Codicefiscale,Residenza) VALUES ('" + P.getNome() + "'," + " '" + P.getCognome() + "',"
							+ " '" + P.getSesso() + "'," + " '" + P.getLuogoNascita() + "'," + " '" + P.getDataNascita()
							+ "'," + " '" + P.getCodicefiscale() + "'," + " '" + P.getResidenza() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removePaziente(String codicefiscale) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("DELETE FROM pazienti WHERE Codicefiscale=" + codicefiscale + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Paziente> getListaPazienti() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM pazienti ORDER BY Nome");

			ResultSet result = statement.executeQuery();

			ArrayList<Paziente> array = new ArrayList<Paziente>();
			while (result.next()) {
				Paziente P = new PazienteImpl(result.getString(1), result.getString(2),
						Enums.Sesso.getFromString(result.getString(3)), result.getString(4),
						LocalDate.parse(result.getString(5), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						result.getString(6), result.getString(7));

				array.add(P);
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void addDottore(Dottore D) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO dottori (Nome,Cognome) VALUES ('" + D.getNome()
					+ "'," + " '" + D.getCognome() + "'," + " '" + D.getSesso() + "'," + " '" + D.getLuogoNascita()
					+ "'," + " '" + D.getDataNascita() + "'," + " '" + D.getTesserino() + "'," + " '" + D.getRuolo()
					+ "'," + " '" + D.getOrarioInizio() + "'," + " '" + D.getOrarioFine() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeDottore(int tesserino) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM dottori WHERE Tesserino=" + tesserino + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Dottore> getListaDottori() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM dottori ORDER BY Nome");

			ResultSet result = statement.executeQuery();

			ArrayList<Dottore> array = new ArrayList<Dottore>();
			while (result.next()) {
				Dottore D = new DottoreImpl(result.getString(1), result.getString(2),
						Enums.Sesso.getFromString(result.getString(3)), result.getString(4),
						LocalDate.parse(result.getString(5), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
						result.getInt(6), Enums.Ruolo.getFromString(result.getString(7)),
						LocalTime.parse(result.getString(8), DateTimeFormatter.ofPattern("HH:mm")),
						LocalTime.parse(result.getString(9), DateTimeFormatter.ofPattern("HH:mm")));
				array.add(D);
			}
			System.out.println("Lista Dottori Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void addMacchinario(Macchinario M) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO macchinari (Codice,Tipo,Disponibilità) VALUES ('" + M.getCodice()
							+ "'," + " '" + M.getTipo() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeMacchinario(String codice) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM macchinari WHERE Codice=" + codice + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Macchinario> getListaMacchinari() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Macchinario> array = new ArrayList<Macchinario>();
			while (result.next()) {
				Macchinario M = new MacchinarioImpl.Builder().codice(result.getString(1)).tipo(result.getString(2))
						.build();
				array.add(M);
			}
			System.out.println("Lista Macchinari Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void addAmbulatorio(Ambulatorio A) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO ambulatori (Codice,Abilitazione,Disponibilità) VALUES ('"
							+ A.getCodice() + "'," + " '" + A.getAbilitazione() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removeAmbulatorio(String codice) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM ambulatori WHERE Codice=" + codice + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Ambulatorio> getListaAmbulatori() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ambulatori ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Ambulatorio> array = new ArrayList<Ambulatorio>();
			while (result.next()) {
				Ambulatorio A = new AmbulatorioImpl.Builder().codice(result.getString(1))
						.abilitazione(result.getString(2)).build();
				array.add(A);
			}
			System.out.println("Lista Ambulatori Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void addPrestazione(Prestazione Pr) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement(

					"INSERT INTO prestazioni (Codice,Abilitazione,Disponibilità) VALUES ('" + Pr.getPaziente() + "','"
							+ Pr.getDottore() + "', '" + Pr.getTipo() + "', '" + Pr.getData() + "', '" + Pr.getOra()
							+ "', '" + Pr.getStato() + "', '" + Pr.getMacchinario() + "', '" + Pr.getAmbulatorio()
							+ "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void removePrestazione(String codicefiscale, int tesserino, LocalDate data, LocalTime ora) throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("DELETE FROM prestazioni WHERE CF_Paziente=" + codicefiscale + " and ID_Dottore ="
							+ tesserino + " and Data = " + data.toString() + " and Ora = " + ora.toString() + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void changeStatoPrestazione(Stato stato, int id) {
		try {
			Connection con = getConnection();
			PreparedStatement posted = con
					.prepareStatement("UPDATE prestazioni WHERE id=" + id + " SET Stato=" + stato.toString() + "");

			posted.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Prestazione> getListaPrestazioni() throws Exception {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM prestazioni ORDER BY Data");

			ResultSet result = statement.executeQuery();

			ArrayList<Prestazione> array = new ArrayList<Prestazione>();
			while (result.next()) {

				Prestazione Pr = new PrestazioneImpl.Builder().paziente(result.getString(1)).dottore(result.getInt(2))
						.tipoprestazione(Enums.TipoPrestazione.getFromString(result.getString(3)))
						.data(LocalDate.parse(result.getString(4), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
						.ora(LocalTime.parse(result.getString(5), DateTimeFormatter.ofPattern("HH:mm")))
						.stato(Enums.Stato.getFromString(result.getString(6))).macchinario(result.getString(7))
						.ambulatorio(result.getString(8)).build();

				array.add(Pr);
			}
			System.out.println("Lista Prestazioni Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
