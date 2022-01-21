package co.edu.cue.banco.controllers;

import java.util.ArrayList;

import co.edu.cue.banco.model.Banco;
import co.edu.cue.banco.model.Empleado;
import javafx.collections.ObservableList;

public class CrudEmpleadoViewController {

	ModelFactoryController modelFactoryController;
	Banco banco;


	public CrudEmpleadoViewController(ModelFactoryController modelFactoryController) {
		this.modelFactoryController = modelFactoryController;
		banco = modelFactoryController.getBanco();
	}
	
	
	public Banco getBanco() {
		return banco;
	}


	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	public ArrayList<Empleado> obtenerEmpleados() {
		
		return modelFactoryController.obtenerEmpleados();
	}


	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) {
		// TODO Auto-generated method stub
		return modelFactoryController.crearEmpleado(nombre, apellido, cedula, fechaNacimiento);
	}


	public boolean eliminarEmpleado(String cedula) {
		
		return modelFactoryController.eliminarEmpleado(cedula);
	}


	public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula,String fechaNacimiento) {
		
		return modelFactoryController.actualizarEmpleado(cedulaActual, nombre, apellido, cedula, fechaNacimiento);
	}

}
