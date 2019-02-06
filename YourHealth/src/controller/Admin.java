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

	public void removePaziente(String codicefiscale) throws Exception {
		try {
			Connection con = Database.getConnection();
			
			PreparedStatement posted = con
					.prepareStatement("DELETE FROM pazienti WHERE Codicefiscale = " + codicefiscale + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Paziente> getListaPazienti() throws Exception {
		try {
			Connection con = Database.getConnection();
			
			PreparedStatement statement = con.prepareStatement("SELECT * FROM pazienti ORDER BY Cognome");

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

	public static void addDottore(Dottore D) throws Exception {
		try {
			Connection con = Database.getConnection();
			
			System.out.println("Nome Paziente: " + D.getNome());
			System.out.println("Cognome Paziente: " + D.getCognome());
			System.out.println("Sesso Paziente: " + D.getSesso());
			System.out.println("Luogo Nascita Paziente: " + D.getLuogoNascita());
			System.out.println("Data Nascita Paziente: " + D.getDataNascita());
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

	public void removeDottore(int tesserino) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM dottori WHERE Tesserino = " + tesserino + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Dottore> getListaDottori() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM dottori ORDER BY Cognome");

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

	public void removeMacchinario(String codice) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM macchinari WHERE Codice = " + codice + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Macchinario> getListaMacchinari() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Macchinario> array = new ArrayList<Macchinario>();
			while (result.next()) {
				Macchinario M = new MacchinarioImpl.Builder().codice(result.getString(1))
						.tipo(Enums.TipoMacchinario.getFromString(result.getString(2)))
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

	public void removeAmbulatorio(String codice) throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement posted = con.prepareStatement("DELETE FROM ambulatori WHERE Codice = " + codice + "");

			posted.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Ambulatorio> getListaAmbulatori() throws Exception {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ambulatori ORDER BY Tipo");

			ResultSet result = statement.executeQuery();

			ArrayList<Ambulatorio> array = new ArrayList<Ambulatorio>();
			while (result.next()) {
				Ambulatorio A = new AmbulatorioImpl.Builder().codice(result.getString(1))
						.tipo(Enums.TipoAmbulatorio.getFromString(result.getString(2))).build();
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

	public void removePrestazione(String codicefiscale, int tesserino, LocalDate data, LocalTime ora) throws Exception {
		try {
			Connection con = Database.getConnection();
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
			Connection con = Database.getConnection();
			PreparedStatement posted = con
					.prepareStatement("UPDATE prestazioni WHERE id=" + id + " SET Stato=" + stato.toString() + "");

			posted.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Prestazione> getListaPrestazioni() throws Exception {
		try {
			Connection con = Database.getConnection();
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
	
	public Paziente getPazienteFromDB(String codicefiscale) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM pazienti WHERE Codicefiscale=" + codicefiscale + "");

			ResultSet result = statement.executeQuery();

			Paziente P = new PazienteImpl(result.getString(1), result.getString(2),
					Enums.Sesso.getFromString(result.getString(3)), result.getString(4),
					LocalDate.parse(result.getString(5), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
					result.getString(6), result.getString(7));
			return P;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Dottore getDottoreFromDB(int tesserino) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM dottori WHERE Tesserino=" + tesserino + "");

			ResultSet result = statement.executeQuery();

			Dottore D = new DottoreImpl(result.getString(1), result.getString(2),
					Enums.Sesso.getFromString(result.getString(3)), result.getString(4),
					LocalDate.parse(result.getString(5), DateTimeFormatter.ofPattern("dd/MM/yyyy")), result.getInt(6),
					Enums.Ruolo.getFromString(result.getString(7)),
					LocalTime.parse(result.getString(8), DateTimeFormatter.ofPattern("HH:mm")),
					LocalTime.parse(result.getString(9), DateTimeFormatter.ofPattern("HH:mm")));
			return D;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Macchinario getMacchinarioFromDB(String codice) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari WHERE Codice=" + codice + "");

			ResultSet result = statement.executeQuery();

			Macchinario M = new MacchinarioImpl.Builder().codice(result.getString(1)).tipo(Enums.TipoMacchinario.getFromString(result.getString(2))).build();
			return M;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public Ambulatorio getAmbulatorioFromDB(String codice) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ambulatori WHERE Codice=" + codice + "");

			ResultSet result = statement.executeQuery();

			Ambulatorio A = new AmbulatorioImpl.Builder().codice(result.getString(1))
					.tipo(Enums.TipoAmbulatorio.getFromString(result.getString(2)))
					.build();
			return A;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean checkDisponibilit‡Prestazione(int tesserino, LocalDate data, LocalTime ora, String codiceMacch,
			String codiceAmb) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM prestazioni WHERE Data=" + data.toString() + " and Ora=" + ora.toString() + "");

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
