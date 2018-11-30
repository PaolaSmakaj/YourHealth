package model;

import java.time.LocalTime;
import java.util.List;

public interface Dottore extends Persona{
	
	/**
     * id getter.
     * @return doctor's id
     */
    int getTesserino();
	
	/**
     * role getter.
     * @return doctor's role
     */
    String getRuolo();
    
    /**
     * clinic getter.
     * @return doctor's clinic
     */
    String getClinica();
    
    /**
     * schedule begin getter.
     * @return doctor's schedule's begin
     */
    LocalTime getOrarioInizio();
    
    /**
     * schedule end getter.
     * @return doctor's schedule's end
     */
    LocalTime getOrarioFine();
    
    /**
     * visit list getter.
     * @return doctor's visit list
     */
    List<Prestazione> getListaPrestazioniDottore();

}
