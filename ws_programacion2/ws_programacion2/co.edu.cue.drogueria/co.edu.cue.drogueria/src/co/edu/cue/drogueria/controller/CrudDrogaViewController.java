package co.edu.cue.drogueria.controller;

import java.util.ArrayList;

import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;

public class CrudDrogaViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudDrogaViewController(ModelFactoryController modelFactory) {
		this.modelFactory = modelFactory;
		drogueria= modelFactory.getDrogueria();
	}

	public Drogueria getDrogueria() {
		return drogueria;
	}

	public void setDrogueria(Drogueria drogueria) {
		this.drogueria = drogueria;
	}
	
	public ArrayList<Producto> obtenerProducto(){
		return modelFactory.obtenerProducto();
	}
	
	public Producto crearProducto(String nombre, String codigo, String valorU, int cantExis){
		return modelFactory.crearProducto(nombre, codigo, valorU, cantExis);
	}
	
	public boolean eliminarProducto(String codigo){
		return modelFactory.eliminarProducto(codigo);
	}
	
	public boolean actualizarProducto(String codigoActual, String nombre, String codigo, String valorU, int cantExis){
		return modelFactory.actualizarProducto(codigoActual, nombre, codigo, valorU, cantExis);
	}
	
	public void guardarDatos() {
		//modelFactory.guardarResourceBinario();
		modelFactory.guardarResourceXML();
	}
	
}
