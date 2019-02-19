package controller;

import java.sql.Connection;
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

public class Admin {

	public static void addPaziente(Paziente P) throws Exception {
		try {
			Connection con = Database.getConnection();

			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO pazienti (Nome,Cognome,Sesso,LuogoNascita,DataNascita,Codicefiscale,Residenza) VALUES ('" + P.getNome() + "'," + " '" + P.getCognome() + "',"
							+ " '" + P.getSesso() + "'," + " '" + P.getLuogoNascita() + "'," + " '" + P.getDataNascita()
							+ "'," + " '" + P.getCodicefiscale() + "'," + " '" + P.getResidenza() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removePaziente(String codicefiscale) throws Exception {
		try {
			Connection con = Database.getConnection();
			
			PreparedStatement posted = con
					.prepareStatement("DELETE FROM pazienti WHERE Codicefiscale = '" + codicefiscale + "'");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Paziente> getListaPazienti() throws Exception {
		try {
			Connection con = Database.getConnection();
			
			PreparedStatement statement = con.prepareStatement("SELECT * FROM pazienti ORDER BY Cognome");

			ResultSet result = statement.executeQuery();

			ArrayList<Paziente> array = new ArrayList<Paziente>();
			while (result.next()) {
				Paziente P = new PazienteImpl(result.getString("Nome"), result.getString("Cognome"),
						Enums.Sesso.getFromString(result.getString("Sesso")), result.getString("LuogoNascita"),
						LocalDate.parse(result.getString("DataNascita"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
						result.getString("Codicefiscale"), result.getString("Residenza"));

				array.add(P);
			}
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void addDottore(Dottore D) throws Exception {
		try {
			Connection con = Database.getConnection();
			
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO dottori (Nome,Cognome,Sesso,LuogoNascita,DataNascita,Tesserino,Ruolo,OrarioInizio,OrarioFine)"
					+ " VALUES ('" + D.getNome() + "'," + " '" + D.getCognome() + "'," + " '" + D.getSesso() + "'," + " '" + D.getLuogoNascita()
					+ "'," + " '" + D.getDataNascita() + "'," + " '" + D.getTesserino() + "'," + " '" + D.getRuolo()
					+ "'," + " '" + D.getOrarioInizio() + "'," + " '" + D.getOrarioFine() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removeDottore(int tesserino) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM dottori WHERE Tesserino = " + tesserino + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Dottore> getListaDottori() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM dottori ORDER BY Cognome");

			ResultSet result = statement.executeQuery();

			ArrayList<Dottore> array = new ArrayList<Dottore>();
			while (result.next()) {
				Dottore D = new DottoreImpl(result.getString("Nome"), result.getString("Cognome"),
						Enums.Sesso.getFromString(result.getString("Sesso")), result.getString("LuogoNascita"),
						LocalDate.parse(result.getString("DataNascita"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
						result.getInt("Tesserino"), Enums.Ruolo.getFromString(result.getString("Ruolo")),
						LocalTime.parse(result.getString("OrarioInizio"), DateTimeFormatter.ofPattern("HH:mm")),
						LocalTime.parse(result.getString("OrarioFine"), DateTimeFormatter.ofPattern("HH:mm")));
				array.add(D);
			}
			System.out.println("Lista Dottori Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void addMacchinario(Macchinario M) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO macchinari (Codice,Tipo) VALUES ('" + M.getCodice()
							+ "'," + " '" + M.getTipo() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removeMacchinario(String codice) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM macchinari WHERE Codice = '" + codice + "'");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Macchinario> getListaMacchinari() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Macchinario> array = new ArrayList<Macchinario>();
			while (result.next()) {
				Macchinario M = new MacchinarioImpl.Builder().codice(result.getString("Codice"))
						.tipo(Enums.TipoMacchinario.getFromString(result.getString("Tipo")))
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

	public static void addAmbulatorio(Ambulatorio A) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con
					.prepareStatement("INSERT INTO ambulatori (Codice,Tipo) VALUES ('"
							+ A.getCodice() + "'," + " '" + A.getTipo() + "')");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removeAmbulatorio(String codice) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM ambulatori WHERE Codice = '" + codice + "'");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Ambulatorio> getListaAmbulatori() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ambulatori ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Ambulatorio> array = new ArrayList<Ambulatorio>();
			while (result.next()) {
				Ambulatorio A = new AmbulatorioImpl.Builder().codice(result.getString("Codice"))
						.tipo(Enums.TipoAmbulatorio.getFromString(result.getString("Tipo"))).build();
				array.add(A);
			}
			System.out.println("Lista Ambulatori Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static void addPrestazione(Prestazione Pr) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement(
					"INSERT INTO prestazioni (CF_Paziente,ID_Dottore,Tipo,Data,Ora,Stato,Macchinario,Ambulatorio)"
					+ " VALUES ('" + Pr.getPaziente() + "','" + Pr.getDottore() + "', '" + Pr.getTipo() + "', '" 
					+ Pr.getData() + "', '" + Pr.getOra() + "', '" + Pr.getStato() + "', '" + Pr.getMacchinario() + "', '"
					+ Pr.getAmbulatorio() + "')");
			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removePrestazione(String codicefiscale, int tesserino, LocalDate data, LocalTime ora) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con
					.prepareStatement("DELETE FROM prestazioni WHERE CF_Paziente='" + codicefiscale + "' and ID_Dottore ="
							+ tesserino + " and Data = '" + data.toString() + "' and Ora = '" + ora.toString() + "'");
			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void changeStatoPrestazione(Stato stato, int id) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con
					.prepareStatement("UPDATE prestazioni WHERE id=" + id + " SET Stato=" + stato.toString() + "");

			posted.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Prestazione> getListaPrestazioni() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM prestazioni ORDER BY Data");

			ResultSet result = statement.executeQuery();

			ArrayList<Prestazione> array = new ArrayList<Prestazione>();
			while (result.next()) {

				Prestazione Pr = new PrestazioneImpl.Builder().paziente(result.getString("CF_Paziente")).dottore(result.getInt("ID_Dottore"))
						.tipoprestazione(Enums.TipoPrestazione.getFromString(result.getString("Tipo")))
						.data(LocalDate.parse(result.getString("Data"), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
						.ora(LocalTime.parse(result.getString("Ora"), DateTimeFormatter.ofPattern("HH:mm")))
						.stato(Enums.Stato.getFromString(result.getString("Stato"))).macchinario(result.getString("Macchinario"))
						.ambulatorio(result.getString("Ambulatorio")).build();

				array.add(Pr);
			}
			System.out.println("Lista Prestazioni Selezionata");
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Macchinario getMacchinarioFromDB(String codice) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari WHERE Codice=" + codice + "");

			ResultSet result = statement.executeQuery();

			Macchinario M = new MacchinarioImpl.Builder()
					.codice(result.getString("Codice"))
					.tipo(Enums.TipoMacchinario.getFromString(result.getString("Tipo")))
					.build();
			return M;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static Ambulatorio getAmbulatorioFromDB(String codice) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ambulatori WHERE Codice=" + codice + "");

			ResultSet result = statement.executeQuery();

			Ambulatorio A = new AmbulatorioImpl.Builder().codice(result.getString("Codice"))
					.tipo(Enums.TipoAmbulatorio.getFromString(result.getString("Tipo")))
					.build();
			return A;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static boolean checkDisponibilit‡Prestazione(int tesserino, LocalDate data, LocalTime ora, String codiceMacch,
			String codiceAmb) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM prestazioni WHERE Data=" + data.toString() + " and Ora=" + ora.toString() + "");

			ResultSet result = statement.executeQuery();

			ArrayList<Prestazione> array = new ArrayList<Prestazione>();
			while (result.next()) {

				Prestazione Pr = new PrestazioneImpl.Builder().paziente(result.getString("CF_Paziente")).dottore(result.getInt("ID_Dottore"))
						.tipoprestazione(Enums.TipoPrestazione.getFromString(result.getString("Tipo")))
						.data(LocalDate.parse(result.getString("Data"), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
						.ora(LocalTime.parse(result.getString("Ora"), DateTimeFormatter.ofPattern("HH:mm")))
						.stato(Enums.Stato.getFromString(result.getString("Stato"))).macchinario(result.getString("Macchinario"))
						.ambulatorio(result.getString("Ambulatorio")).build();

				array.add(Pr);
			}
			for (Prestazione object : array) {
				if (object.getDottore() == tesserino || object.getMacchinario() == codiceMacch
						|| object.getAmbulatorio() == codiceAmb) {
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

}
