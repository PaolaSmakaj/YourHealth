package model;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Prestazione {
 
    /**
     * clinic getter.
     * @return performance's clinic
     */
    String getClinica();
    
	/**
     * patient getter.
     * @return performance's patient
     */
    Paziente getPaziente();
    
    /**
     * doctor getter.
     * @return performance's doctor
     */
    Dottore getDottore();
    
    /**
     * type getter.
     * @return performance's type
     */
    String getTipo();
    
    /**
     * date getter.
     * @return performance's date
     */
    LocalDate getData();
    
    /**
     * hour getter.
     * @return performance's hour
     */
    LocalTime getOra();
    
    /**
     * status getter.
     * @return performance's status
     */
    String getStato();
    
    /**
     * code getter.
     * @return performance's code
     */
    String getCodice();
    
    /**
     * machine getter.
     * @return performance's machine
     */
    String getMacchinario();
}
