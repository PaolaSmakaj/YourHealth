package model;


import java.io.Serializable;
import java.time.LocalDate;

import util.Enums.Sesso;

public final class PazienteImpl extends PersonaImpl.Builder implements Paziente, Serializable {

	private static final long serialVersionUID = 1L;
    private final String codicefiscale;
    private final String residenza;
    
    private PazienteImpl(final String codicefiscale, final String residenza, final String nome, 
    		final String cognome, final Sesso sesso, final String luogonascita, final int annonascita) {
    	this.codicefiscale = codicefiscale;
    	this.residenza = residenza;
    }
    
    public static class Builder {
    	private String nome1;
        private String cognome1;
        private Sesso sesso1;
        private String luogonascita1;
        private int annonascita1;
        private String codicefiscale1;
        private String residenza1;

        /**
         * adds the fiscal code. 
         * @param cf fiscal code
         * @return patient
         */
        public Builder codicefiscale(final String cf) {
            this.codicefiscale1 = cf;
            return this;
        }
        /**
         * adds the address. 
         * @param res address
         * @return patient
         */
        public Builder residenza(final String res) {
            this.residenza1 = res;
            return this;
        }
    
        
    
        public Paziente build() throws IllegalArgumentException {
        	if (this.codicefiscale1.isEmpty() || this.residenza1.isEmpty()) { 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new PazienteImpl(this.nome1, this.cognome1, 
        			this.luogonascita1, this.codicefiscale1, this.sesso1, this.residenza1, this.annonascita1);
        	}
        }
    
    @Override
    public String getCodicefiscale() {
        return this.codicefiscale;
    }
    
    @Override
    public String getResidenza() {
        return this.residenza;
    }
    
    @Override
    public String toString() {
        return this.residenza + ", " + this.codicefiscale;
    }

	@Override
	public String getNome() {
		return this.getNome();
	}

	@Override
	public String getCognome() {
		return this.getCognome();
	}

	@Override
	public String getSesso() {
		return this.getSesso();
	}

	@Override
	public String getLuogoNascita() {
		return this.getLuogoNascita();
	}

	@Override
	public LocalDate getDataNascita() {
		return this.getDataNascita();
	}
    
}
