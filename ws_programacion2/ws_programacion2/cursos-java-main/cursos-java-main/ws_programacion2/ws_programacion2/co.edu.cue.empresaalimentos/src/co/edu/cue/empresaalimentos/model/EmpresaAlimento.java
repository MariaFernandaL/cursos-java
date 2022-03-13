package co.edu.cue.empresaalimentos.model;

import java.util.ArrayList;

public class EmpresaAlimento {

	private String nombre;
	
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	
	
	public EmpresaAlimento() {
		// TODO Auto-generated constructor stub
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



	public Producto crearProducto(String nombre2, String codigo, String descripcion) {
		Producto producto = null;
		producto = obtenerProducto(codigo);
		
		if(producto == null){
			producto = new Producto();
			getListaProductos().add(producto);
		}
		return producto;
	}

	private Producto obtenerProducto(String codigo) {
		Producto productoEncontrado = null;
		
		for (Producto producto : listaProductos) {
			if(producto.getCodigo().equals(codigo)){
				productoEncontrado = producto;
				break;
			}
		}
		return productoEncontrado;
	}



	@Override
	public String toString() {
		return "EmpresaAlimento [nombre=" + nombre + "]";
	}
	
	
}
