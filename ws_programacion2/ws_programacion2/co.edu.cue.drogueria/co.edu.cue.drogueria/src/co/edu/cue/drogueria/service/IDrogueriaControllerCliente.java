package co.edu.cue.drogueria.service;

import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.model.Cliente;

public interface IDrogueriaControllerCliente {
	Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion) throws ClienteException;
	boolean actualizarCliente(String cedulaActual,String nombre, String cedula, String telefono, String correo, String direccion );
	Boolean eliminarCliente(String cedula)throws ClienteException;
	Cliente obtenerCliente(String cedula);
	ArrayList<Cliente> obtenerClientes();
}
