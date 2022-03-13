package co.edu.cue.empresaalimentos.services;

import co.edu.cue.empresaalimentos.model.Producto;

public interface IModelFactoryController {

	
	public Producto crearProducto(String nombre, String codigo, String descripcion);
}
