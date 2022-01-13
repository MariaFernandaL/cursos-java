package co.edu.cue.empresaalimentos.model;

import co.edu.cue.empresaalimentos.service.ObjetoRefrigerable;

public class DrogaFarmacologica implements ObjetoRefrigerable{

	private String codigo;
	private String nombre; 
	
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


	@Override
	public void iniciarProcesoRefrigeracion() {
		
	}

	
}
