package co.edu.cue.banco.services;

import java.util.ArrayList;

import co.edu.cue.banco.exception.EmpleadoException;
import co.edu.cue.banco.model.Empleado;

public interface IBancoService {

	
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) throws EmpleadoException;
	public boolean actualizarEmpleado(String cedulaActual,String nombre, String apellido, String cedula, String fechaNacimiento);
	public Boolean eliminarEmpleado(String cedula)throws EmpleadoException;
	public boolean  verificarEmpleadoExistente(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
	
}
