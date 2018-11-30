package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.Enums.Sesso;
import util.Enums.Ruolo;

public class DottoreImpl extends PersonaImpl.Builder implements Dottore, Serializable{
	
	private static final long serialVersionUID = 1L;
	private final int tesserino;
    private final Ruolo ruolo;
    private final Clinica clinica;
    private final LocalTime orarioinizio;
    private final LocalTime orariofine;
    private final List<Prestazione> listaprestazioni;
    
    private DottoreImpl(final int tesserino, final Ruolo ruolo, final Clinica clinica, final LocalTime orarioinizio, 
    		final LocalTime orariofine, final List<Prestazione> listaprestazioni, final String nome, final String cognome, 
    		final Sesso sesso, final String luogonascita, final int annonascita) {
    	this.tesserino = tesserino;
    	this.ruolo = ruolo;
    	this.clinica = clinica;
    	this.orarioinizio = orarioinizio;
    	this.orariofine = orariofine;
    	this.listaprestazioni = listaprestazioni;
    }
    
    public static class Builder {

    	private int tesserino1;
    	private String nome1;
        private String cognome1;
        private Sesso sesso1;
        private String luogonascita1;
        private int annonascita1;
    	private Ruolo ruolo1;
        private Clinica clinica1;
        private LocalTime orarioinizio1;
        private LocalTime orariofine1;
        private List<Prestazione> listaprestazioni1 = new ArrayList<>();
        /**
         * adds the id code. 
         * @param id id code
         * @return doctor
         */
        public Builder tesserino(final int id) {
            this.tesserino1 = id;
            return this;
        }
        /**
         * adds the role. 
         * @param r role
         * @return doctor
         */
        public Builder ruolo(final Ruolo r) {
            this.ruolo1 = r;
            return this;
        }
        /**
         * adds the clinic. 
         * @param c clinic
         * @return doctor
         */
        public Builder clinica(final Clinica c) {
            this.clinica1 = c;
            return this;
        }
        /**
         * adds the shedule's begin. 
         * @param oi schedule
         * @return doctor
         */
        public Builder orarioinizio(final LocalTime oi) {
            this.orarioinizio1 = oi;
            return this;
        }
        
        /**
         * adds the shedule's end. 
         * @param of schedule
         * @return doctor
         */
        public Builder orariofine(final LocalTime of) {
            this.orariofine1 = of;
            return this;
        }
        
    	public Dottore build() throws IllegalArgumentException {
        	if (this.tesserino1 != 0 || this.clinica1.getNome().isEmpty() || this.orarioinizio1 == null || this.orariofine1 == null || this.listaprestazioni1.isEmpty()) { 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new DottoreImpl(this.tesserino1, this.ruolo1, this.clinica1, this.orarioinizio1, this.orariofine1,  this.listaprestazioni1, this.nome1, this.cognome1, this.sesso1, 
        			this.luogonascita1, this.annonascita1);
        	}
    }
    
    @Override
	public int getTesserino() {
		return this.tesserino;
	}
    
	@Override
    public String getRuolo() {
        return this.ruolo.getRuolo();
    }
    
    @Override
    public String getClinica() {
        return this.clinica.getNome();
    }
    
    @Override
    public LocalTime getOrarioInizio() {
        return this.orarioinizio;
    }
    
    @Override
    public LocalTime getOrarioFine() {
        return this.orariofine;
    }
    
    @Override
    public List<Prestazione> getListaPrestazioniDottore() {
        return listaprestazioni;
    }
    
    @Override
    public String toString() {
        return this.ruolo + ", " + this.clinica + ", " + this.orarioinizio.toString() + ", " + this.orariofine.toString();
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
