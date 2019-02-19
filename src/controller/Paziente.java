package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Prestazione;
import model.PrestazioneImpl;
import util.Enums;

public class Paziente {
	
	public ArrayList<Prestazione> listaPrestazioniPaziente(String codicefiscale) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM prestazioni WHERE CF_Paziente=" + codicefiscale + "");

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
			return array;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static boolean checkEsistenzaCodiceFiscale (String Codicefiscale) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM pazienti WHERE Codicefiscale=" + Codicefiscale + "");

			ResultSet result = statement.executeQuery();
			
			if (result == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
