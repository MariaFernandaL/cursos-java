package co.edu.cue.drogueria.model;

import java.io.Serializable;

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String codigo;
	private String valorU;
	private int cantExis;
	
	
	
	public Producto(){
		
	}
	
	public Producto(String nombre, String codigo, String valorU, int cantExis) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.valorU = valorU;
		this.cantExis = cantExis;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValorU() {
		return valorU;
	}
	public void setValorU(String valorU) {
		this.valorU = valorU;
	}
	public int getCantExis() {
		return cantExis;
	}
	public void setCantExis(int cantExis) {
		this.cantExis = cantExis;
	}
}
