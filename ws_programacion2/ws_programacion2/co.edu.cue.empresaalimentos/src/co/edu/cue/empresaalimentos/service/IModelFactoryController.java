package co.edu.cue.empresaalimentos.service;

import co.edu.cue.empresaalimentos.model.Producto;

public interface IModelFactoryController {

	
	public Producto crearProducto(String nombre, String codigo, double precioCompra, String descripcion);


}
