package model;

import java.io.Serializable;

public class MacchinarioImpl implements Macchinario, Serializable{

	private static final long serialVersionUID = 1L;
    private final String codice;
    private final String tipo;
    private final boolean disponibilit�;
    
    private MacchinarioImpl(final String codice, final String tipo, final boolean disponibilit�) {
    	this.codice = codice;
    	this.tipo = tipo;
    	this.disponibilit� = disponibilit�;
    }
    
    public static class Builder {
    	private String codice1;
    	private String tipo1;
    	private boolean disponibilit�1;
    	
    	public Builder codice(String c) {
    		this.codice1 = c;
    		return this;
    	}
    	
    	public Builder tipo(String t) {
    		this.tipo1 = t;
    		return this;
    	}
    	
    	public Builder disponibilit�(boolean d) {
    		this.disponibilit�1 = d;
    		return this;
    	}
    	
    	public Macchinario build() throws IllegalArgumentException {
        	if (this.codice1.isEmpty() || this.tipo1.isEmpty()) { 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new MacchinarioImpl(this.codice1, this.tipo1, this.disponibilit�1);
        	}
    	}
    	

	@Override
	public String getCodice() {
		return this.codice;
	}

	@Override
	public String getTipo() {
		return this.tipo;
	}

	@Override
	public boolean getDisponibilit�() {
		return this.disponibilit�;
	}
}
