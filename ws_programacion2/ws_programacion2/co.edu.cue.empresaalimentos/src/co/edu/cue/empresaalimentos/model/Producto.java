package co.edu.cue.empresaalimentos.model;

public class Producto {

	private String codigo;
	private String nombre;
	private double precioCompra;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	
	public void calcularPrecioVenta(){
		
	}
}
