package co.edu.cue.drogueria.controller;

import java.util.ArrayList;

import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;

public class CrudEmpleadoViewController {

	ModelFactoryController modelFactory;
	Drogueria drogueria;
	
	public CrudEmpleadoViewController(ModelFactoryController modelFactory) {
		this.modelFactory = modelFactory;
		drogueria= modelFactory.getDrogueria();
	}

	public Drogueria getDrogueria() {
		return drogueria;
	}

	public void setDrogueria(Drogueria drogueria) {
		this.drogueria = drogueria;
	}
	
	public ArrayList<Empleado> obtenerEmpleado(){
		return modelFactory.obtenerEmpleados();
	}
	
	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario){
		return modelFactory.crearEmpleado(nombre, cedula, telefono, correo, salario);
	}
	
	public boolean eliminarEmpleado(String cedula){
		return modelFactory.eliminarEmpleado(cedula);
	}
	
	public boolean actualizarEmpleado(String cedulaActual,String nombre, String cedula, String telefono, String correo, String salario){
		return modelFactory.actualizarEmpleado(cedulaActual, nombre, cedula, telefono, correo, salario);
	}
	public void guardarDatos() {
		//modelFactory.guardarResourceBinario();
		modelFactory.guardarResourceXML();
	}
	
}
