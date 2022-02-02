package co.edu.cue.preParcial1.Ejercicio2;

import java.io.Serializable;

public class Programa implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombreP;
	private String codigoP;
	private String modalidad;
	
	
	public Programa(){
		
	}
	
	public Programa(String nombreP, String codigoP, String modalidad) {
		super();
		this.nombreP = nombreP;
		this.codigoP = codigoP;
		this.modalidad = modalidad;
	}
	public String getNombreP() {
		return nombreP;
	}
	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}
	public String getCodigoP() {
		return codigoP;
	}
	public void setCodigoP(String codigoP) {
		this.codigoP = codigoP;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	@Override
	public String toString() {
		return "Programa: " + nombreP + ". Codigo: " + codigoP + ". Modalidad: " + modalidad;
	}
	
	
}
