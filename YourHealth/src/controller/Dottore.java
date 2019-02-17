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

public class Dottore {

	public ArrayList<Prestazione> listaPrestazioniDottore(int tesserino) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement statement = con
					.prepareStatement("SELECT * FROM prestazioni WHERE ID_Dottore=" + tesserino + "");

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

}
