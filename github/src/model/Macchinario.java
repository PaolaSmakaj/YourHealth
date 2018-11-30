package model;


public interface Macchinario {

	/**
     * code getter
     * @return machine's code
     */
    String getCodice();
    
	/**
     * type getter
     * @return machine's type
     */
    String getTipo();
    
    /**
     * availability getter.
     * @return machine's availability
     */
    boolean getDisponibilità();
}
