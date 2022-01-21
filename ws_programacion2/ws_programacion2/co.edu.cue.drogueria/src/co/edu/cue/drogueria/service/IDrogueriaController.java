package co.edu.cue.drogueria.service;

import java.util.ArrayList;

import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.model.Empleado;

public interface IDrogueriaController {

	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario) throws EmpleadoException;
	public boolean actualizarEmpleado(String cedulaActual,String nombre, String cedula, String telefono, String correo, String salario );
	public Boolean eliminarEmpleado(String cedula)throws EmpleadoException;
	public boolean verificarEmpleadoExistente(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
}
