package co.edu.cue.drogueria.service;

import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.exception.ProductoException;
import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;

public interface IDrogueriaController {

	//EMPLEADO
	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario) throws EmpleadoException;
	public boolean actualizarEmpleado(String cedulaActual,String nombre, String cedula, String telefono, String correo, String salario );
	public Boolean eliminarEmpleado(String cedula)throws EmpleadoException;
	public boolean verificarEmpleadoExistente(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
	
	//CLIENTE
	public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion) throws ClienteException;
	public boolean actualizarCliente(String cedulaActual,String nombre, String cedula, String telefono, String correo, String direccion );
	public Boolean eliminarCliente(String cedula)throws ClienteException;
	public boolean verificarClienteExistente(String cedula);
	public Cliente obtenerCliente(String cedula);
	public ArrayList<Cliente> obtenerClientes();
	
	//PRODUCTO
	public Producto crearProducto(String nombre, String codigo, String valorU, int cantExis) throws ProductoException;
	public boolean actualizarProducto(String codigoActual,String nombre, String codigo, String valorU, int cantExis);
	public Boolean eliminarProducto(String codigo)throws ProductoException;
	public boolean verificarProductoExistente(String codigo);
	public Producto obtenerProducto(String codigo);
	public ArrayList<Producto> obtenerProductos();
}
