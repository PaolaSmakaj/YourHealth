package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class ControllerImpl implements Controller {

	public static Connection getConnection() throws Exception {
		try {
			String url = "jdbc:mysql://localhost:3306/javaproject";
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

	@Override
	public Paziente getPazienteFromDB(String codicefiscale) {
		try {
			Connection con = getConnection();
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

	@Override
	public Dottore getDottoreFromDB(int tesserino) {
		try {
			Connection con = getConnection();
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

	@Override
	public Macchinario getMacchinarioFromDB(String codice) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM macchinari WHERE Codice=" + codice + "");

			ResultSet result = statement.executeQuery();

			Macchinario M = new MacchinarioImpl.Builder().codice(result.getString(1)).tipo(Enums.TipoMacchinario.getFromString(result.getString(2))).build();
			return M;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Ambulatorio getAmbulatorioFromDB(String codice) {
		try {
			Connection con = getConnection();
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

	@Override
	public boolean checkDisponibilit‡Prestazione(int tesserino, LocalDate data, LocalTime ora, String codiceMacch,
			String codiceAmb) {
		try {
			Connection con = getConnection();
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

	@Override
	public ArrayList<Prestazione> listaPrestazioniPaziente(String codicefiscale) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM prestazioni WHERE CF_Paziente=" + codicefiscale + "");

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
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public ArrayList<Prestazione> listaPrestazioniDottore(int tesserino) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM prestazioni WHERE ID_Dottore=" + tesserino + "");

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
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
