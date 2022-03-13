package co.edu.cue.preParcial1.Ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombreU;

	
	public Universidad(){
		
	}
	
	
	public Universidad(String nombreU) {
		super();
		this.nombreU = nombreU;
	}

	public String getNombreU() {
		return nombreU;
	}

	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}
	
	ArrayList<Facultad> listaFacultades= new ArrayList<>();

	public ArrayList<Facultad> getListaFacultades() {
		return listaFacultades;
	}

	public void setListaFacultades(ArrayList<Facultad> listaFacultades) {
		this.listaFacultades = listaFacultades;
	}

	@Override
	public String toString() {
		return nombreU;
	}
	
	
	
	
}
