package model;

import java.io.Serializable;
import util.Enums.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class PrestazioneImpl implements Prestazione, Serializable {

	private static final long serialVersionUID = 1L;
    private final Clinica clinica;
    private final Paziente paziente;
    private final Dottore dottore;
    private final TipoPrestazione tipo;
    private final LocalDate data;
    private final LocalTime ora;
    private final Stato stato;
    private final String codice;
    private final Macchinario macchinario;
    
    private PrestazioneImpl(final Clinica clinica, final Paziente paziente, final Dottore dottore, final TipoPrestazione tipo, 
    		final LocalDate data, final LocalTime ora, final Stato stato, final String codice, final Macchinario macchinario) {
    	this.clinica = clinica;
    	this.paziente = paziente;
    	this.dottore = dottore;
    	this.tipo = tipo;
    	this.data = data;
    	this.ora = ora;
    	this.stato = stato;
    	this.codice = codice;
    	this.macchinario = macchinario;
    }
    public static class Builder {
    	private Clinica clinica1;
        private Paziente paziente1;
        private Dottore dottore1;
        private TipoPrestazione tipo1;
        private LocalDate data1;
        private LocalTime ora1;
        private Stato stato1;
        private String codice1;
        private Macchinario macchinario1;
        
        /**
         * adds the clinic. 
         * @param cl clinic
         * @return performance
         */
        public Builder clinica(final Clinica cl) {
            this.clinica1 = cl;
            return this;
        }
        /**
         * adds the patient. 
         * @param p patient
         * @return performance
         */
        public Builder paziente(final Paziente p) {
            this.paziente1 = p;
            return this;
        }
        /**
         * adds the doctor. 
         * @param doc doctor
         * @return performance
         */
        public Builder dottore(final Dottore doc) {
            this.dottore1 = doc;
            return this;
        }
        /**
         * adds the type of performance. 
         * @param t type
         * @return performance
         */
        public Builder tipoprestazione(final TipoPrestazione t) {
            this.tipo1 = t;
            return this;
        }
        /**
         * adds the date. 
         * @param d performance's date
         * @return performance
         */
        public Builder data(final LocalDate d) {
            this.data1 = d;
            return this;
        }
        /**
         * adds the hour. 
         * @param d performance's hour
         * @return performance
         */
        public Builder ora(final LocalTime h) {
            this.ora1 = h;
            return this;
        }
        /**
         * adds the status. 
         * @param d performance's status
         * @return performance
         */
        public Builder stato(final Stato s) {
            this.stato1 = s;
            return this;
        }
        /**
         * adds the code. 
         * @param c performance's code
         * @return performance
         */
        public Builder codice(final String c) {
            this.codice1 = c;
            return this;
        }
        
        /**
         * adds the machine. 
         * @param c performance's machine
         * @return performance
         */
        public Builder macchinario(final Macchinario m) {
            this.macchinario1 = m;
            return this;
        }
        
        
        public Prestazione build() throws IllegalArgumentException {
        	if (this.clinica1.getNome().isEmpty() || this.paziente1.getNome().isEmpty() || this.dottore1.getNome().isEmpty() 
        			|| this.tipo1.getTipo().isEmpty() || this.data1 == null || this.ora1 == null || this.stato1.getStato().isEmpty()
        			|| this.codice1.isEmpty() ||this.macchinario1.getCodice().isEmpty()) { 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new PrestazioneImpl(this.clinica1, this.paziente1, this.dottore1, this.tipo1, 
        			this.data1, this.ora1, this.stato1, this.codice1, this.macchinario1);
        	}
    }
    
	@Override
	public String getClinica() {
		return this.clinica.getNome();
	}

	@Override
	public Paziente getPaziente() {
		return this.paziente;
	}

	@Override
	public Dottore getDottore() {
		return this.dottore;
	}

	@Override
	public String getTipo() {
		return this.tipo.getTipo();
	}

	@Override
	public LocalDate getData() {
		return this.data;
	}
	
	@Override
	public LocalTime getOra() {
		return this.ora;
	}

	@Override
	public String getStato() {
		return this.stato.getStato();
	}

	@Override
	public String getCodice() {
		return this.codice;
	}

	@Override
	public String getMacchinario() {
		return this.macchinario.getCodice();
	}
	
    
}
