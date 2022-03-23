package co.edu.cue.drogueria.model;

import java.io.Serializable;


public class Domicilio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String numeroDomicilio;
	private String fecha;
	private Cliente cliente;
	private Producto producto;
	private Empleado empleado;
	private String direccion;
	private double costo;
	
	
	public Domicilio(){
		
	}
	
	
	private String nombreCliente;
	private String nombreEmpleado;
	private String nombreProducto;
	
	public String getNombreCliente() {
		return this.cliente.getNombre();
	}
	public String getNombreEmpleado() {
		return this.empleado.getNombre();
	}
	public String getNombreProducto() {
		return this.producto.getNombre();
	}
	
	
	public Domicilio(String numeroDomicilio, String fecha, Cliente cliente, Producto producto, Empleado empleado, String direccion, double costo) {
		super();
		this.numeroDomicilio = numeroDomicilio;
		this.fecha = fecha;
		this.cliente = cliente;
		this.producto = producto;
		this.empleado= empleado;
		this.direccion= direccion;
		this.costo= costo;
	}
	
	public String getNumeroDomicilio() {
		return numeroDomicilio;
	}
	public void setNumeroDomicilio(String numeroDomicilio) {
		this.numeroDomicilio= numeroDomicilio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}	
}
