package co.edu.cue.drogueria.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.service.IDrogueriaControllerCliente;

public class DrogueriaCliente implements IDrogueriaControllerCliente, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public DrogueriaCliente() {
		
	}
	
	
	ArrayList<Cliente> listaClientes= new ArrayList<>();
	
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}



		@Override
		public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion)
				throws ClienteException {
			
			Cliente cliente =  null;
			boolean existeClien= false;
			existeClien= verificarClienteExistente(cedula);
			if (existeClien== true) {
				throw new ClienteException("El cliente con cedula: "+ cedula+" no se puede crear, Ya existe");
			} else {

				cliente= new Cliente();
				cliente.setNombre(nombre);
				cliente.setCedula(cedula);
				cliente.setTelefono(telefono);
				cliente.setCorreoE(correo);
				cliente.setDireccion(direccion);
				getListaClientes().add(cliente);
			}
			
			return cliente;
		}
		
		@Override
		public boolean actualizarCliente(String cedulaActual, String nombre, String cedula, String telefono, String correo,
				String direccion) {
			
			Cliente cliente = null;
			boolean clienteActualizado = false;
			
			cliente = obtenerCliente(cedulaActual);
			
			if(cliente != null){
				
				cliente.setNombre(nombre);
				cliente.setCedula(cedula);
				cliente.setTelefono(telefono);
				cliente.setCorreoE(correo);
				cliente.setDireccion(direccion);
				clienteActualizado=true;
	}
			return clienteActualizado;
		}
		@Override
		public Boolean eliminarCliente(String cedula) throws ClienteException {
			
			boolean eliminado = false;
			 Cliente cliente = null;
			
			cliente = obtenerCliente(cedula);
			
			if(cliente != null){
				
				getListaClientes().remove(cliente);
				eliminado = true;
			}else{
				throw new ClienteException("El cliente con cédula "+ cedula+" no se puede eliminar. No existe");
			}
			
			return eliminado;
		}

		private boolean verificarClienteExistente(String cedula) {

			boolean clienteExiste= false;
			
			for (Cliente cliente  : listaClientes) {
				if (cliente.getCedula().equalsIgnoreCase(cedula)) {
					clienteExiste=true;
					break;
				}
			}
			return clienteExiste;
		}
		@Override
		public Cliente obtenerCliente(String cedula) {
			
			Cliente clienteExiste= null;
			for (Cliente cliente : listaClientes) {
				if (cliente.getCedula().equalsIgnoreCase(cedula)) {
					clienteExiste= cliente;
					break;
				}
			}
			
			return clienteExiste;
		}
		@Override
		public ArrayList<Cliente> obtenerClientes() {
			// TODO Auto-generated method stub
			return null;
		}
}
