package co.edu.cue.banco.model;

import java.util.ArrayList;

import co.edu.cue.banco.exception.EmpleadoException;
import co.edu.cue.banco.services.IBancoService;

public class Banco implements IBancoService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Cliente> listaClientes = new ArrayList<>();
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();
	ArrayList<Cuenta> listaCuentas = new ArrayList<>();
	ArrayList<Transaccion> listaTransaccionesAsociadas = new ArrayList<Transaccion>();
	
	public Banco() {
		
	}
	

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}
	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Cuenta> getListaCuentas() {
		return listaCuentas;
	}


	public void setListaCuentas(ArrayList<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}


	public ArrayList<Transaccion> getListaTransaccionesAsociadas() {
		return listaTransaccionesAsociadas;
	}


	public void setListaTransaccionesAsociadas(ArrayList<Transaccion> listaTransaccionesAsociadas) {
		this.listaTransaccionesAsociadas = listaTransaccionesAsociadas;
	}


	@Override
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) throws EmpleadoException {
		
		
		Empleado nuevoEmpleado = null;
		boolean flagEmpleadoExiste= false;
		
		flagEmpleadoExiste = verificarEmpleadoExistente(cedula);
		
		if(flagEmpleadoExiste == true){
			throw new EmpleadoException("El empleado con cédula "+ cedula+" no se puede crear. Ya existe");
		}else{
			nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setApellido(apellido);
			nuevoEmpleado.setCedula(cedula);
			nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
			getListaEmpleados().add(nuevoEmpleado);
		}
		
		return nuevoEmpleado;
	}


	@Override
	public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		Empleado empleado = null;
		boolean empleadoActualizado = false;
		
		empleado = obtenerEmpleado(cedulaActual);
		
		if(empleado != null){
			
			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			empleado.setCedula(cedula);
			empleado.setFechaNacimiento(fechaNacimiento);
			empleadoActualizado = true;
		}
		
		return empleadoActualizado;
	}


	@Override
	public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
		
		boolean flagEliminado = false;
		Empleado empleado = null;
		
		empleado = obtenerEmpleado(cedula);
		
		if(empleado != null){
			
			getListaEmpleados().remove(empleado);
			flagEliminado = true;
		}else{
			throw new EmpleadoException("El empleado con cédula "+ cedula+" no se puede eliminar. No existe");
		}
		
		return flagEliminado;
	}


	@Override
	public boolean verificarEmpleadoExistente(String cedula) {
		
		boolean flagEmpleadoExiste =  false;
		
		
		for (Empleado empleado : listaEmpleados) {
			
			if(empleado.getCedula().equalsIgnoreCase(cedula)){
				flagEmpleadoExiste = true;
				break;
			}
		}
		
		return flagEmpleadoExiste;
	}


	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Empleado obtenerEmpleado(String cedula) {
		
		Empleado empleadoEncontrado = null;
		
		for (Empleado empleado : listaEmpleados) {
			
			if(empleado.getCedula().equalsIgnoreCase(cedula)){
				empleadoEncontrado = empleado;
				break;
			}
		}
		
		return empleadoEncontrado;
	}

	
	
	

}
