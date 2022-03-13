package co.edu.cue.empresaalimentos.model;

import java.util.ArrayList;

public class Proveedor {

	private String nombre;
	private ArrayList<Producto> listaProductosProveedores= new ArrayList<Producto>();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Producto> getListaProductosProveedores() {
		return listaProductosProveedores;
	}
	public void setListaProductosProveedores(ArrayList<Producto> listaProductosProveedores) {
		this.listaProductosProveedores = listaProductosProveedores;
	}
	
	
	
}
