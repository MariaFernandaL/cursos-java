package co.edu.cue.drogueria.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.service.IDrogueriaControllerCliente;
import co.edu.cue.drogueria.service.IDrogueriaControllerEmpleado;

public class DrogueriaEmpleado implements IDrogueriaControllerEmpleado, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public DrogueriaEmpleado() {
		
	}
	
	
	ArrayList<Empleado> listaEmpleado= new ArrayList<>();
	
	
	public ArrayList<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}
	public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}



	@Override
	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario)
			throws EmpleadoException {
		
		Empleado empleado=  null;
		boolean existeEmpl= false;
		existeEmpl= verificarEmpleadoExistente(cedula);
		if (existeEmpl== true) {
			throw new EmpleadoException("El empleado con cedula: "+ cedula+" no se puede crear, Ya existe");
		} else {

			empleado= new Empleado();
			empleado.setNombre(nombre);
			empleado.setCedula(cedula);
			empleado.setTelefono(telefono);
			empleado.setCorreoE(correo);
			empleado.setSalario(salario);
			getListaEmpleado().add(empleado);
		}
		
		return empleado;
	}
	
	@Override
	public boolean actualizarEmpleado(String cedulaActual, String nombre, String cedula, String telefono, String correo,
			String salario) {
		
		Empleado empleado = null;
		boolean empleadoActualizado = false;
		
		empleado = obtenerEmpleado(cedulaActual);
		
		if(empleado != null){
			
			empleado.setNombre(nombre);
			empleado.setCedula(cedula);
			empleado.setTelefono(telefono);
			empleado.setCorreoE(correo);
			empleado.setSalario(salario);
			empleadoActualizado=true;
}
		return empleadoActualizado;
	}
	@Override
	public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
		
		boolean eliminado = false;
		Empleado empleado = null;
		
		empleado = obtenerEmpleado(cedula);
		
		if(empleado != null){
			
			getListaEmpleado().remove(empleado);
			eliminado = true;
		}else{
			throw new EmpleadoException("El empleado con cédula "+ cedula+" no se puede eliminar. No existe");
		}
		
		return eliminado;
	}
	
	private boolean verificarEmpleadoExistente(String cedula) {

		boolean empleadoExiste= false;
		
		for (Empleado empleado : listaEmpleado) {
			if (empleado.getCedula().equalsIgnoreCase(cedula)) {
				empleadoExiste=true;
				break;
			}
		}
		return empleadoExiste;
	}
	
	@Override
	public Empleado obtenerEmpleado(String cedula) {
		
		Empleado empleadoExiste= null;
		for (Empleado empleado : listaEmpleado) {
			if (empleado.getCedula().equalsIgnoreCase(cedula)) {
				empleadoExiste= empleado;
				break;
			}
		}
		
		return empleadoExiste;
	}
	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
}
