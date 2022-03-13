package co.edu.cue.empresaalimentos.model;

public class Producto {

	private String codigo;
	private String nombre;
	private String precioCompra;
	private String descripcion;
	
	public Producto(){
		
	}
	public Producto(String codigo, String nombre, String precioCompra, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.descripcion = descripcion;
	}
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
	public String getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(String precio) {
		this.precioCompra = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void calcularPrecioVenta(){
		
	}
}
