package co.edu.cue.drogueria.controller;

import java.util.ArrayList;

import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import co.edu.cue.drogueria.model.Domicilio;

public class CrudDomicilioViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudDomicilioViewController(ModelFactoryController modelFactory) {
		this.modelFactory = modelFactory;
		drogueria= modelFactory.getDrogueria();
	}

	public Drogueria getDrogueria() {
		return drogueria;
	}

	public void setDrogueria(Drogueria drogueria) {
		this.drogueria = drogueria;
	}
	
	public ArrayList<Domicilio> obtenerDomicilios(){
		return modelFactory.obtenerDomicilio();
	}
	
	public Domicilio crearDomicilio(String numeroDomicilio, String fecha, Cliente cliente, Producto producto,
			Empleado empleado, String direccion, double costo){
		return modelFactory.crearDomicilio(numeroDomicilio, fecha,cliente,producto,empleado,direccion,costo);
	}
	
	public boolean eliminarDomicilio(String numeroDomicilio){
		return modelFactory.eliminarDomicilio(numeroDomicilio);
	}
	
	public boolean actualizarDomicilio(String numeroDomicilioActual, String numeroDomicilio, String fecha,
			Cliente cliente, Producto producto, Empleado empleado, String direccion, double costo){
		return modelFactory.actualizarDomicilio(numeroDomicilioActual,numeroDomicilio, fecha,cliente,producto,empleado,direccion,costo);
	}
	
	public void guardarDatos() {
		//modelFactory.guardarResourceBinario();
		modelFactory.guardarResourceXML();
	}
}
