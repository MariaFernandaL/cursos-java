package co.edu.cue.tallerApropiacion.model;

public class Contacto {

	private String nombre;
	private String telefono;

	
	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Contacto() {
		
	}

	
	//get-set
	//nombre
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//telefono
	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 	
	
	
	public boolean existeContacto(Contacto c) {
		if (this.nombre.equalsIgnoreCase(c.getNombre())) {
			return true;
		}
		return false;
	}
	
	
	public String mostrarContacto() {
		return "Nombre:  "+nombre+" telefono: "+telefono;
	}
	
	
	
	
	
}