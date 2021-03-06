package co.edu.cue.drogueria.service;

import java.util.ArrayList;

import co.edu.cue.drogueria.exception.DomicilioException;
import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import co.edu.cue.drogueria.model.Domicilio;


public interface IModelFactoryController {

	//EMPLEADO
	public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario);
	public Boolean eliminarEmpleado(String cedula);
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();
	boolean actualizarEmpleado(String cedulaActual, String nombre, String cedula, String telefono, String correo, String salario);
	
	//CLIENTE
	public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion);
	public Boolean eliminarCliente(String cedula);
	public Cliente obtenerCliente(String cedula);
	public ArrayList<Cliente> obtenerClientes();
	boolean actualizarCliente(String cedulaActual, String nombre, String cedula, String telefono, String correo, String direccion);
	
	//PRODUCTO
	public Producto crearProducto(String nombre, String codigo, String valorU, int cantExis);
	public Boolean eliminarProducto(String codigo);
	public Producto obtenerProducto(String codigo);
	public ArrayList<Producto> obtenerProducto();
	boolean actualizarProducto(String codigoActual, String nombre, String codigo, String valorU, int cantExis);
	
	//DOMICILIO
	public Domicilio crearDomicilio(String numeroDomicilio, String fecha, Cliente cliente, Producto producto, Empleado empleado, String direccion, double costo);
	public Boolean eliminarDomicilio(String numeroDomicilio);
	public Domicilio obtenerDomicilio(String numeroDomicilio);
	public ArrayList<Domicilio> obtenerDomicilio();
	boolean actualizarDomicilio(String numeroDomicilioActual,String numeroDomicilio, String fecha, Cliente cliente, Producto producto, Empleado empleado, String direccion, double costo);
	
}
