package co.edu.cue.banco.services;

import java.util.ArrayList;

import co.edu.cue.banco.model.Empleado;

public interface IModelFactoryService {

	
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento);
	public Boolean eliminarEmpleado(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
	boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula, String fechaNacimiento);
	
	
}
