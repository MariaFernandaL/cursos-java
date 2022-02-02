package programacion2.parcial1.ejercicio1;

public class Cliente {

	private String codigo;
	private String cedula;
	private String tipoIdentificacion;
	private String nombre;
	private String apellido;
	private String telefono;
	
	public Cliente(){
		
	}

	public Cliente(String codigo, String cedula, String tipoIdentificacion, String nombre, String apellido,
			String telefono) {
		super();
		this.codigo = codigo;
		this.cedula = cedula;
		this.tipoIdentificacion = tipoIdentificacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes. Codigo=" + codigo + ". Cedula=" + cedula + ". Tipo de Identificacion=" + tipoIdentificacion
				+ ". Nombre=" + nombre + ". Apellido=" + apellido + ". Telefono=" + telefono;
	}
	
	
}
