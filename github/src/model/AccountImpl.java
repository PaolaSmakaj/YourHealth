package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountImpl implements Account, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nomeUtente;
	private String password;
	private final List<Prestazione> listaprenotazioni;
	
	public AccountImpl(final String nomeUtente, final String password) {
		this.nomeUtente = nomeUtente;
		this.password = password;
		this.listaprenotazioni = new ArrayList<>();
	}
	
	
	@Override
	public void setPassword(final String password) {
		if (password.equals("")) {
			throw new IllegalStateException("Password non valida!");
		} else {
			this.password = password;
		}
	}
	

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setNomeUtente(String username) {
		if (username.equals("")) {
			throw new IllegalStateException("Nome utente non valido!");
		} else {
			this.nomeUtente = username;
		}
	}

	@Override
	public String getNomeUtente() {
		return this.nomeUtente;
	}

	@Override
	public void removePrestazione(String codice) {
		
	}

	@Override
	public List<Prestazione> getListaPrenotazioni() {
		return listaprenotazioni;
	}

}
