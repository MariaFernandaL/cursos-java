package co.edu.cue.empresaalimentos.model;

import java.util.ArrayList;

public class EmpresaAlimento {

	private String nombre;
	
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private ArrayList<Producto> listaProductos= new ArrayList<Producto>();
	private ArrayList<DrogaFarmacologica> listaDrogaFarmacologica= new ArrayList<DrogaFarmacologica>();
	
	
	public EmpresaAlimento() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Proveedor> getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(ArrayList<Proveedor> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<DrogaFarmacologica> getListaDrogaFarmacologica() {
		return listaDrogaFarmacologica;
	}

	public void setListaDrogaFarmacologica(ArrayList<DrogaFarmacologica> listaDrogaFarmacologica) {
		this.listaDrogaFarmacologica = listaDrogaFarmacologica;
	}

	public void agregarProveedor(){
		
	}
	
	public void agregarProducto(){
		
	}
	
	public void agregarDrogaFarmacologica(){
		
	}
}
