package co.edu.cue.drogueria.model;

import java.io.Serializable;

public class Persona implements Serializable{

	private String nombre;
	private String cedula;
	private String telefono;
	private String correoE;
	
	private static final long serialVersionUID = 1L;

	public Persona(){
		
	}
	
	public Persona(String nombre, String cedula, String telefono, String correoE) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correoE = correoE;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoE() {
		return correoE;
	}
	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}
}
