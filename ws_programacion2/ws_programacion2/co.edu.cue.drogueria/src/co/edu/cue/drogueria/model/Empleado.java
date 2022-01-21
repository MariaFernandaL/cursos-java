package co.edu.cue.drogueria.model;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String salario;
	
	
	public Empleado(){
		
	}
	
	public Empleado(String nombre, String cedula, String telefono, String correoE, String salario) {
		super(nombre, cedula, telefono, correoE);
		this.salario = salario;
	}

	
	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}


	@Override
	public String toString() {
		return "Salario Empleado: " + salario + ". Nombre: " + getNombre() + ". Cedula: " + getCedula()
				+ ". Telefono:" + getTelefono() + ". CorreoE:" + getCorreoE();
	}
}
