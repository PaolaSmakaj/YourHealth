package model;

import java.util.List;

public interface Clinica {
	
	/**
     * name getter.
     * @return clinic's name
     */
    String getNome();
    
	/**
     * add patient to the clinic database.
     * @param p
     */
    void addPaziente(final Paziente p);
    
	/**
     * remove patient to the clinic database.
     * @param codicefiscale
     */
    void removePaziente(final String codicefiscale);
    
    /**
     * patient's list getter.
     * @return patient's list
     */
    List<Paziente> getListaPazienti();
    
    /**
     * add doctor to the clinic database.
     * @param d
     */
    void addDottore(final Dottore d);
    
	/**
     * remove doctor to the clinic database.
     * @param tesserino
     */
    void removeDottore(final String tesserino);
    
    /**
     * doctor's list getter.
     * @return doctor's list
     */
    List<Dottore> getListaDottori();
    
    /**
     * add performance to the clinic database.
     * @param pr
     */
    void addPrestazione(final Prestazione pr);
    
	/**
     * remove performance to the clinic database.
     * @param codice
     */
    void removePrestazione(final String codice);
    
    /**
     * performance's list getter.
     * @return performance's list
     */
    List<Prestazione> getListaPrestazioni();
    
    /**
     * add machine to the clinic database.
     * @param m
     */
    void addMacchinario(final Macchinario m);
    
	/**
     * remove machine to the clinic database.
     * @param codice
     */
    void removeMacchinario(final String codice);
    
    /**
     * patient's list getter.
     * @return patient's list
     */
    List<Macchinario> getListaMacchinari();
}
