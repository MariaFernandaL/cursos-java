package co.edu.cue.drogueria.model;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.exception.ProductoException;
import co.edu.cue.drogueria.service.IDrogueriaController;

public class Drogueria implements IDrogueriaController, Serializable{

	private static final long serialVersionUID = 1L;
	
	public Drogueria(){
		
	}
	
	ArrayList<Producto> listaProductos= new ArrayList<>();
	ArrayList<Empleado> listaEmpleado= new ArrayList<>();
	ArrayList<Cliente> listaClientes= new ArrayList<>();
	ArrayList<Domicilio> listaVentas= new ArrayList<>();
	
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public ArrayList<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}
	public void setListaEmpleado(ArrayList<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Domicilio> getListaVentas() {
		return listaVentas;
	}
	public void setListaVentas(ArrayList<Domicilio> listaVentas) {
		this.listaVentas = listaVentas;
	}
	
	//EMPLEADO
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
	@Override
	public boolean verificarEmpleadoExistente(String cedula) {

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
	
	//CLIENTE
	@Override
	public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion)
			throws ClienteException {
		
		Cliente cliente =  null;
		boolean existeClien= false;
		existeClien= verificarEmpleadoExistente(cedula);
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
	@Override
	public boolean verificarClienteExistente(String cedula) {

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
	
	//PRODUCTO
	@Override
	public Producto crearProducto(String nombre, String codigo, String valorU, int cantExis) throws ProductoException {
		Producto producto =  null;
		boolean existeProduct= false;
		existeProduct= verificarProductoExistente(codigo);
		if (existeProduct== true) {
			throw new ProductoException("El producto con codigo: "+ codigo+" no se puede crear, Ya existe");
		} else {

			producto= new Producto();
			producto.setNombre(nombre);
			producto.setCodigo(codigo);
			producto.setValorU(valorU);
			producto.setCantExis(cantExis);
			
			getListaProductos().add(producto);
		}
		
		return producto;
	}
	@Override
	public boolean actualizarProducto(String codigoActual, String nombre, String codigo, String valorU, int cantExis) {
		
		Producto producto = null;
		boolean productoActualizado = false;
		
		producto = obtenerProducto(codigoActual);
		
		if(producto != null){
			
			producto.setNombre(nombre);
			producto.setCodigo(codigo);
			producto.setValorU(valorU);
			producto.setCantExis(cantExis);
			productoActualizado=true;
}
		return productoActualizado;
		
	}
	@Override
	public Boolean eliminarProducto(String codigo) throws ProductoException {
		
		boolean eliminado = false;
		Producto producto = null;
		
		producto = obtenerProducto(codigo);
		
		if(producto != null){
			
			getListaProductos().remove(producto);
			eliminado = true;
		}else{
			throw new ProductoException("El producto con codigo "+ codigo+" no se puede eliminar. No existe");
		}
		
		return eliminado;
	}
	@Override
	public boolean verificarProductoExistente(String codigo) {
		boolean productoExiste= false;
		
		for (Producto producto  : listaProductos) {
			if (producto.getCodigo().equalsIgnoreCase(codigo)) {
				productoExiste=true;
				break;
			}
		}
		return productoExiste;
	}
	@Override
	public Producto obtenerProducto(String codigo) {
		Producto productoExiste= null;
		for (Producto producto: listaProductos) {
			if (producto.getCodigo().equalsIgnoreCase(codigo)) {
				productoExiste= producto;
				break;
			}
		}
		
		return productoExiste;
	}
	@Override
	public ArrayList<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}
}
