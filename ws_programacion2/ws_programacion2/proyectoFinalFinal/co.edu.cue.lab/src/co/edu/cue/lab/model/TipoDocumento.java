package co.edu.cue.lab.model;

public enum TipoDocumento {
	CEDULA(0), PASAPORTE(1), CEDULA_EXTRANJERA(2);

	private int numTipo;

	private TipoDocumento(int numTipo) {
		this.numTipo = numTipo;
	}

		public int getNumTipo() {
		return numTipo;
	}

	public void setNumTipo(int numTipo) {
		this.numTipo = numTipo;
	}

	public TipoDocumento getTipoDocumento(int index) {

		switch(index) {

		case 0: return TipoDocumento.CEDULA;

		case 1: return TipoDocumento.PASAPORTE;

		case 2: return TipoDocumento.CEDULA_EXTRANJERA;

		default: return null;

		}

	}
}
