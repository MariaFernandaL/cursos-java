package co.edu.cue.empresaalimentos.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EmpresaAlimento{

	private String nombreE;
	
	private ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
	private ArrayList<Producto> listaProductos= new ArrayList<Producto>();
	private ArrayList<DrogaFarmacologica> listaDrogaFarmacologica= new ArrayList<DrogaFarmacologica>();
	
	public EmpresaAlimento(){
		
	}
	
	public EmpresaAlimento(String nombre) {
		nombreE= nombre;
	}

	public String getNombre() {
		return nombreE;
	}

	public void setNombre(String nombre) {
		this.nombreE = nombre;
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

	//productos
	
	public Producto agregarProducto(String nombre, String codigo, String precioCompra, String descripcion){
		
		Producto producto = null;

		producto = obtenerProducto(codigo);
		
		if (producto==null) {
			Producto nuevoProducto= new Producto();
			nuevoProducto.setNombre(nombre);
			nuevoProducto.setCodigo(codigo);
			nuevoProducto.setPrecioCompra(precioCompra);
			nuevoProducto.setDescripcion(descripcion);
			getListaProductos().add(nuevoProducto);
			return nuevoProducto;
		} else {
			JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado");
			return null;
		}
	}
	
	public boolean eliminarProducto(String codigo) {

		Producto producto = null;

		producto = obtenerProducto(codigo);

		if(producto != null){
			getListaProductos().remove(producto);
			return true;
		}else{
			return false;
		}

	}
	
	public Producto obtenerProducto(String codigo) {

		for (Producto producto : listaProductos) {

			if(producto.getCodigo().equals(codigo))
			{
				return producto;
			}
		}
		return null;

	}
	
	public boolean actualizarProducto(String codigoActual, String nombre, String codigo, String precio, String  descripcion) {

		Producto producto = null;

		producto = obtenerProducto(codigoActual);

		if(producto != null){

			producto.setNombre(nombre);
			producto.setCodigo(codigo);
			producto.setPrecioCompra(precio);
			producto.setDescripcion(descripcion);

			return true;
		}else{
			return false;
		}


	}
	

	
	
	
	public void agregarProveedor(){
		
	}
	
	
	
	public void agregarDrogaFarmacologica(){
		
	}

	@Override
	public String toString() {
		return "EmpresaAlimento [nombre=" + nombreE + "]";
	}
	
	
}
