package model;

import java.io.Serializable;

public class MacchinarioImpl implements Macchinario, Serializable{

	private static final long serialVersionUID = 1L;
    private final String codice;
    private final String tipo;
    private final boolean disponibilitÓ;
    
    private MacchinarioImpl(final String codice, final String tipo, final boolean disponibilitÓ) {
    	this.codice = codice;
    	this.tipo = tipo;
    	this.disponibilitÓ = disponibilitÓ;
    }
    
    public static class Builder {
    	private String codice1;
    	private String tipo1;
    	private boolean disponibilitÓ1;
    	
    	public Builder codice(String c) {
    		this.codice1 = c;
    		return this;
    	}
    	
    	public Builder tipo(String t) {
    		this.tipo1 = t;
    		return this;
    	}
    	
    	public Builder disponibilitÓ(boolean d) {
    		this.disponibilitÓ1 = d;
    		return this;
    	}
    	
    	public Macchinario build() throws IllegalArgumentException {
        	if (this.codice1.isEmpty() || this.tipo1.isEmpty()) { 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new MacchinarioImpl(this.codice1, this.tipo1, this.disponibilitÓ1);
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
	public boolean getDisponibilitÓ() {
		return this.disponibilitÓ;
	}
}
