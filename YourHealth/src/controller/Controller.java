package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Ambulatorio;
import model.Dottore;
import model.Macchinario;
import model.Paziente;
import model.Prestazione;

public interface Controller {

	Paziente getPazienteFromDB(String codicefiscale);

	Dottore getDottoreFromDB(int tesserino);

	Macchinario getMacchinarioFromDB(String codice);

	Ambulatorio getAmbulatorioFromDB(String codice);

	boolean checkDisponibilit‡Prestazione(int tesserino, LocalDate data, LocalTime ora, String codiceMacch,
			String codiceAmb);

	ArrayList<Prestazione> listaPrestazioniPaziente(String codicefiscale);

	ArrayList<Prestazione> listaPrestazioniDottore(int tesserino);

}
