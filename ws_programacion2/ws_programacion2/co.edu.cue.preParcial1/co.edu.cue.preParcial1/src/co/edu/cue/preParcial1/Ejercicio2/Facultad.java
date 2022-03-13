package co.edu.cue.preParcial1.Ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;

public class Facultad implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombreF;

	
	public Facultad(){
		
	}
	
	public Facultad(String nombreF) {
		super();
		this.nombreF = nombreF;
	}

	public String getNombreF() {
		return nombreF;
	}

	public void setNombreF(String nombreF) {
		this.nombreF = nombreF;
	}
	
	ArrayList<Programa> listaProgramas= new ArrayList<>();

	public ArrayList<Programa> getListaProgramas() {
		return listaProgramas;
	}

	public void setListaProgramas(ArrayList<Programa> listaProgramas) {
		this.listaProgramas = listaProgramas;
	}

	@Override
	public String toString() {
		return "Facultad: " + nombreF;
	}
	
	
	
}
