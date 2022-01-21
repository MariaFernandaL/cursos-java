package co.edu.cue.drogueria.model;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String direccion;

	
	public Cliente(){
		
	}
	
	public Cliente(String nombre, String cedula, String telefono, String correoE, String direccion) {
		super(nombre, cedula, telefono, correoE);
		this.direccion = direccion;
	}
	

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Direccion Cliente" + direccion + ". Nombre: " + getNombre() + ". Cedula: " + getCedula()
				+ ". Telefono: " + getTelefono() + ". CorreoE: " + getCorreoE();
	}
	
}
