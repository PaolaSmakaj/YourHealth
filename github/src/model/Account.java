package model;

import java.util.List;

public interface Account {

	/**
	 * set password.
	 * @param password
	 */
	void setPassword(final String password);
	/**
	 * password's getter
	 * @return password.
	 */
	String getPassword();
	/**
	 * set user name.
	 * @param username
	 */
	void setNomeUtente(final String username);
	/**
	 * 
	 * @return user name.
	 */
	String getNomeUtente();
	
	//TODO setPrenotazione (the query is right here)
	
	/**
     * dismiss a reserved performance.
     * @param codice
     */
    void removePrestazione(final String codice);
    
	/**
     * performance's list getter.
     * @return performance's list
     */
    List<Prestazione> getListaPrenotazioni();
}
