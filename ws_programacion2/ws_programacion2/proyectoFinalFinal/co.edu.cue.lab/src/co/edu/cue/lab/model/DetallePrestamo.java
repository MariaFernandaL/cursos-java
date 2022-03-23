package co.edu.cue.lab.model;

public class DetallePrestamo {

	
	private Elemento elemento;
	private int cantidad;
	
	private String nombreElemento;
	
	public String getNombreElemento() {
		return this.elemento.getNombreElemento();
	}
	
	
	
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public DetallePrestamo(Elemento elemento, int cantidad) {
		super();
		this.elemento = elemento;
		this.cantidad = cantidad;
	}
	public DetallePrestamo() {
		
	}
	
}
