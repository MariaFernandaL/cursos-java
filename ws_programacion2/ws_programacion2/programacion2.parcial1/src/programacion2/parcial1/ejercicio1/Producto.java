package programacion2.parcial1.ejercicio1;

public class Producto {

	private String codigo;
	private String nombre;
	private double precio;
	private String descripcion;
	private String estado;
	
	public Producto(){
		
	}

	public Producto(String codigo, String nombre, double precio, String descripcion, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos. Codigo=" + codigo + ". Nombre=" + nombre + ". Precio=" + precio + ". Descripcion=" + descripcion+ ". Estado=" + estado;
	}
	
	
	
}
