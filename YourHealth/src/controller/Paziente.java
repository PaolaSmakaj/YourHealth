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
