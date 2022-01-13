package co.edu.cue.empresaalimentos.model;

public class ProductoRefrigerado extends Producto{

	private String codigoAprobacion;
	private double temperatura;
	public String getCodigoAprobacion() {
		return codigoAprobacion;
	}
	public void setCodigoAprobacion(String codigoAprobacion) {
		this.codigoAprobacion = codigoAprobacion;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	
}
