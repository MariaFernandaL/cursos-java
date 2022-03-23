package co.edu.cue.lab.model;


public class Estudiante {
	
	private String documento;
	private String nombre;
	private String apellido;
	private String genero;
	private String ciudadResidencia;
	private TipoDocumento tipoDocumento;
	private String direccion;



	/**
	 * Constructor del Estudiante
	 * @param documento, nombre, genero, ciudadResidencia, tipoDocumento
	 */




	public Estudiante() {
		
	}



	public Estudiante(String documento, String nombre, String apellido, String genero, String ciudadResidencia,
			TipoDocumento tipoDocumento, String direccion) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.ciudadResidencia = ciudadResidencia;
		this.tipoDocumento = tipoDocumento;
		this.direccion = direccion;
	}



	/**
	 *
	 * @return
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 *
	 * @param documento
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 *
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 *
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 *
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 *
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 *
	 * @return
	 */
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	/**
	 *
	 * @param ciudadResidencia
	 */
	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	/**
	 *
	 * @return
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 *
	 * @param tipoDocumento
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return "Estudiante \nDocumento: " + documento + "\nNombre:" + nombre + "\nGénero=" + genero + "\nCiudad Residencia: "
				+ ciudadResidencia + "\nTipo Documento=: " + tipoDocumento;
	}

}
