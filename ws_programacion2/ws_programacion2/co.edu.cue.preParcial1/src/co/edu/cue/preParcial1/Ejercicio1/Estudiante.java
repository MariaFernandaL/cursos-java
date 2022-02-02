package co.edu.cue.preParcial1.Ejercicio1;

import java.io.Serializable;

public class Estudiante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String nota1;
	private String nota2;
	private String nota3;
	
	public Estudiante(){
		
	}
	
	
	public Estudiante(String codigo, String nombre, String nota1, String nota2, String nota3) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
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
	public String getNota1() {
		return nota1;
	}
	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}
	public String getNota2() {
		return nota2;
	}
	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
	public String getNota3() {
		return nota3;
	}
	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}


	@Override
	public String toString() {
		return "Codigo: " + codigo + ". Nombre: " + nombre + ". Nota1: " + nota1 + ". Nota2: " + nota2
				+ ". Nota3: " + nota3;
	}

}
