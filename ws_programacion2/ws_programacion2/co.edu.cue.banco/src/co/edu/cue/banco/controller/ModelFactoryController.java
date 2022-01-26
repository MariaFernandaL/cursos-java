package co.edu.cue.banco.controller;


import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.banco.exception.EmpleadoException;
import co.edu.cue.banco.model.Banco;
import co.edu.cue.banco.model.Cliente;
import co.edu.cue.banco.model.Empleado;
import co.edu.cue.banco.persistencia.BoundedSemaphore;
import co.edu.cue.banco.persistencia.Persistencia;
import co.edu.cue.banco.services.IModelFactoryService;

public class ModelFactoryController implements IModelFactoryService, Runnable{

	Banco banco;
	Thread hiloServicio1_Persistencia;
	BoundedSemaphore semaforo = new BoundedSemaphore(1);
	
	
	//------------------------------  Singleton ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder { 
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Método para obtener la instancia de nuestra clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}
	
	public ModelFactoryController() {

		//1. inicializar datos del modelo
		//inicializarDatos();
		
		//2. guardar los datos de los empleados en un archivo
		/*try {
			Persistencia.guardarEmpleados(getBanco().getListaEmpleados());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		//Cargar la informacion de los empleados desde un archivo
		try {
			Persistencia.cargarDatosArchivos(banco);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		//PERSISTIR LA INFORMACION ARCHIVO BINARIO
		//guardarResourceBinario();
		//cargarResourceBinario();
		
		//PERSISTIR INFO ARCHIVO XML
		//guardarResourceXML();
		cargarResourceXML();
		
		if (banco==null) {
			inicializarDatos();
			guardarResourceXML();
		}
	}

	
		

		
	private void inicializarDatos() {

		banco = new Banco();
		
		
		Cliente cliente = new Cliente();
		cliente.setNombre("juan");
		cliente.setApellido("arias");
		cliente.setCedula("125454");
		cliente.setDireccion("Armenia");
		cliente.setCorreo("uni1@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);

		cliente = new Cliente();
		cliente.setNombre("Pedro");
		cliente.setApellido("Perez");
		cliente.setCedula("77787");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni2@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		cliente = new Cliente();
		cliente.setNombre("Alberto");
		cliente.setApellido("Arias");
		cliente.setCedula("12555");
		cliente.setDireccion("Pererira");
		cliente.setCorreo("uni3@");
		cliente.setFechaNacimiento("12454");
		cliente.setTelefono("125444");

		banco.getListaClientes().add(cliente);
		
		
		Empleado empleado = new Empleado();
		empleado.setNombre("juan");
		empleado.setApellido("arias");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		
		empleado = new Empleado();
		empleado.setNombre("Ana");
		empleado.setApellido("alzate");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		empleado = new Empleado();
		empleado.setNombre("Pedro");
		empleado.setApellido("perez");
		empleado.setCedula("125454");
		empleado.setFechaNacimiento("12454");
		banco.getListaEmpleados().add(empleado);
		
		System.out.println("Banco inicializado "+banco );
		
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}


	@Override
	public Empleado crearEmpleado(String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		
		Empleado empleado = null;
		
		try {
			empleado = getBanco().crearEmpleado(nombre, apellido, cedula, fechaNacimiento);
		} catch (EmpleadoException e) {
			e.getMessage();
		}
		
		return empleado;
		
	}

	@Override
	public boolean actualizarEmpleado(String cedulaActual, String nombre, String apellido, String cedula, String fechaNacimiento) {
		
		return getBanco().actualizarEmpleado(cedulaActual, nombre, apellido, cedula, fechaNacimiento);
	}

	@Override
	public Boolean eliminarEmpleado(String cedula) {
		
		boolean flagEmpleadoExiste = false;
		
		try {
			flagEmpleadoExiste = getBanco().eliminarEmpleado(cedula);
		} catch (EmpleadoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return flagEmpleadoExiste;
	}

	@Override
	public Empleado obtenerEmpleado(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		
		return banco.getListaEmpleados();
	}
	
	//PERSISTENCIA
	//XML
		public void guardarResourceXML() {
			Persistencia.guardarRecursoBancoXML(banco);	
		}
		public void cargarResourceXML() {
			banco= Persistencia.cargarRecursoBancoXML();
		}
		
		//BINARIO
		public void cargarResourceBinario() {
			banco=Persistencia.cargarRecursoBancoBinario();
		}
		public void guardarResourceBinario() {
			Persistencia.guardarRecursoBancoBinario(banco);
		}
		
	//HILOS
	@Override
	public void run() {

		//HILO PARA MANEJAR LA PERSISTENCIA 
		
		//HILO PARA REGISTRAR LAS ACCIONES DEL SISTEMA 
		
		//HILO PARA GENERAR ARCHIVO DE INTEGRACION
		
		//HILO PARA GENERAR REPORTE 
	}
	
	
}
