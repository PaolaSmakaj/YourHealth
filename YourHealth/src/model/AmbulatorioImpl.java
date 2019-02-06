package model;

import java.io.Serializable;

public class AmbulatorioImpl implements Ambulatorio, Serializable {

	private static final long serialVersionUID = -8959280214682117086L;
	private final String codice;
	private final String abilitazioni;

	private AmbulatorioImpl(final String codice, final String abilitazione) {
		this.codice = codice;
		this.abilitazioni = abilitazione;
	}

	public static class Builder {
		private String codice1;
		private String abilitazioni1;

		public Builder codice(String c) {
			this.codice1 = c;
			return this;
		}

		public Builder abilitazione(String a) {
			this.abilitazioni1 = a;
			return this;
		}

		public Ambulatorio build() throws IllegalArgumentException {
			if (this.codice1.isEmpty() || this.abilitazioni1.isEmpty()) {
				throw new IllegalArgumentException("Invalid Input");
			}
			return new AmbulatorioImpl(this.codice1, this.abilitazioni1);
		}
	}

	@Override
	public String getCodice() {
		return this.codice;
	}

	@Override
	public String getAbilitazione() {
		return this.abilitazioni;
	}
}
