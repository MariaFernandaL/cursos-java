package co.edu.cue.drogueria.controller;

import java.util.ArrayList;

import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;

public class CrudClienteViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudClienteViewController(ModelFactoryController modelFactory) {
		this.modelFactory = modelFactory;
		drogueria= modelFactory.getDrogueria();
	}

	public Drogueria getDrogueria() {
		return drogueria;
	}

	public void setDrogueria(Drogueria drogueria) {
		this.drogueria = drogueria;
	}
	
	public ArrayList<Cliente> obtenerCliente(){
		return modelFactory.obtenerClientes();
	}
	
	public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion){
		return modelFactory.crearCliente(nombre, cedula, telefono, correo, direccion);
	}
	
	public boolean eliminarCliente(String cedula){
		return modelFactory.eliminarCliente(cedula);
	}
	
	public boolean actualizarCliente(String cedulaActual,String nombre, String cedula, String telefono, String correo, String direccion){
		return modelFactory.actualizarCliente(cedulaActual, nombre, cedula, telefono, correo, direccion);
	}
	
	public void guardarDatos() {
		//modelFactory.guardarResourceBinario();
		modelFactory.guardarResourceXML();
	}
}
