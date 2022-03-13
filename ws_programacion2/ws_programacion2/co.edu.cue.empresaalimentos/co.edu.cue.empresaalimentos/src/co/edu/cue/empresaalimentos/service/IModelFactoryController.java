package co.edu.cue.empresaalimentos.service;

import java.util.ArrayList;

import co.edu.cue.empresaalimentos.model.Producto;

public interface IModelFactoryController {

	
	public Producto crearProducto(String nombre, String codigo, String precioCompra, String descripcion);

	public Boolean eliminarProducto(String codigo);
	
	public Boolean actualizarProducto(String codigoActual, String nombre, String codigo, String precioCompra, String  descripcion);

	public Producto obtenerProducto(String codigo);
	
	public ArrayList<Producto> obtenerProductos();
}
