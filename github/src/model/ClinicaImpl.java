package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ClinicaImpl implements Clinica, Serializable{

	private static final long serialVersionUID = 1L;
    private final String nome;
    private final List<Paziente> listapazienti;
    private final List<Dottore> listadottori;
    private final List<Prestazione> listaprestazioni;
    private final List<Macchinario> listamacchinari;
    
    public ClinicaImpl(final String nome){
    	this.nome = nome;
    	this.listapazienti = new ArrayList<>();
    	this.listadottori = new ArrayList<>();
    	this.listaprestazioni = new ArrayList<>();
    	this.listamacchinari = new ArrayList<>();
    }
    
    public static class Builder{
    	private String nome1;
        
    	public Builder nome(final String n) {
    		this.nome1 = n;
    		return this;
    	}
        
    	public Clinica build() throws IllegalArgumentException {
    		if (this.nome1.isEmpty()){ 
        		throw new IllegalArgumentException("Invalid Input");
        		}
        	return new ClinicaImpl(this.nome1);
        	}
    }

	public String getNome() {
		return this.nome;
	}

	@Override
	public void addPaziente(Paziente p) {
		listapazienti.forEach(pat -> {
            if (pat.getCodicefiscale() == p.getCodicefiscale()) {
                throw new IllegalStateException("Paziente già registrato");
            }
        });
        listapazienti.add(p);
	}

	@Override
	public void removePaziente(String codicefiscale) {
	}

	@Override
	public List<Paziente> getListaPazienti() {
		return listapazienti;
	}

	@Override
	public void addDottore(Dottore d) {
		listadottori.forEach(doc -> {
            if (doc.getTesserino() == d.getTesserino()) {
                throw new IllegalStateException("Dottore già registrato");
            }
        });
        listadottori.add(d);
	}

	@Override
	public void removeDottore(String tesserino) {
		
	}

	@Override
	public List<Dottore> getListaDottori() {
		return listadottori;
	}

	@Override
	public void addPrestazione(Prestazione pr) {
		listaprestazioni.forEach(prest -> {
            if (prest.getCodice() == pr.getCodice()) {
                throw new IllegalStateException("Prestazione già in elenco");
            }
        });
        listaprestazioni.add(pr);
	}

	@Override
	public void removePrestazione(String codice) {
		
	}

	@Override
	public List<Prestazione> getListaPrestazioni() {
		return listaprestazioni;
	}

	@Override
	public void addMacchinario(Macchinario m) {
		listamacchinari.forEach(mac -> {
            if (mac.getCodice() == m.getCodice()) {
                throw new IllegalStateException("Macchinario già registrato");
            }
        });
        listamacchinari.add(m);
	}

	@Override
	public void removeMacchinario(String codice) {
		
	}

	@Override
	public List<Macchinario> getListaMacchinari() {
		return listamacchinari;
	}

}
