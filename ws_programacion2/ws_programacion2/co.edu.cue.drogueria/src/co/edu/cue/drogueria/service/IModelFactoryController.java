package co.edu.cue.drogueria.service;

import java.util.ArrayList;

import co.edu.cue.drogueria.model.Empleado;


public interface IModelFactoryController {

	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario);
	public Boolean eliminarEmpleado(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
	boolean actualizarEmpleado(String cedulaActual, String nombre, String cedula, String telefono, String correo, String salario);
	
}
