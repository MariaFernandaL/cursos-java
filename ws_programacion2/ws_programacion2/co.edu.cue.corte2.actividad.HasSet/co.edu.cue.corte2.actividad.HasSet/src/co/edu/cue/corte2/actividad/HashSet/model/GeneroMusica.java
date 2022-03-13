package co.edu.cue.corte2.actividad.HashSet.model;

public class GeneroMusica {

	private String genero;
	private String codigo;
	public GeneroMusica(){
	}
	public GeneroMusica(String genero, String codigo) {
		super();
		this.genero = genero;
		this.codigo = codigo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public int hashCode() {
		int resultado=1;
		resultado= resultado+codigo.hashCode();
		return resultado;
	}
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
			return true;
		}
		if (obj==null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		GeneroMusica otro= (GeneroMusica) obj;
		if (codigo==null) {
			if (otro.codigo!=null) {
				return false;
			}else if (!codigo.equals(otro.codigo)) {
				return false;
			}
		}
		return true;
	}
}
