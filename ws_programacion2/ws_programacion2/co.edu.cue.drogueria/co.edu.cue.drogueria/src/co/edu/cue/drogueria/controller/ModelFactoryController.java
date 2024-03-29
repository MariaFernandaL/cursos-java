package co.edu.cue.drogueria.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.drogueria.exception.ClienteException;
import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.exception.ProductoException;
import co.edu.cue.drogueria.exception.DomicilioException;
import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Domicilio;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import co.edu.cue.drogueria.persistencia.BoundedSemaphore;
import co.edu.cue.drogueria.persistencia.Persistencia;
import co.edu.cue.drogueria.service.IModelFactoryController;

public class ModelFactoryController implements IModelFactoryController, Runnable{

	Drogueria drogueria;
	Thread hiloServicio1_Persistencia;
	Thread hiloServicio2_RegistrarAcciones;
	BoundedSemaphore semaforo = new BoundedSemaphore(1);
	private String mensajeLog;
	private int nivel;
	private String accion;
	
	
	//------------------------------  Singleton ------------------------------------------------
		// Clase estatica oculta. Tan solo se instanciara el singleton una vez
		private static class SingletonHolder { 
			// El constructor de Singleton puede ser llamado desde aqu� al ser protected
			private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
		}

		// M�todo para obtener la instancia de nuestra clase
		public static ModelFactoryController getInstance() {
			return SingletonHolder.eINSTANCE;
		}
		
		public ModelFactoryController() {

			//inicializarDatos();
			/*
			try {
				Persistencia.guardarEmpleados(getDrogueria().getListaEmpleado());
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				Persistencia.cargarDatosArchivos(drogueria);
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
			
			if (drogueria==null) {
				inicializarDatos();
				guardarResourceXML();
			}
		}

		private void inicializarDatos() {
			
			drogueria= new Drogueria();
			
			Empleado empleado= new Empleado();
			empleado.setNombre("pepito");
			empleado.setCedula("76878");
			empleado.setTelefono("5463892928");
			empleado.setCorreoE("pepito@gmail.com");
			empleado.setSalario("345.788");
			drogueria.getListaEmpleado().add(empleado);
			
			empleado= new Empleado();
			empleado.setNombre("pablo");
			empleado.setCedula("37847");
			empleado.setTelefono("3526476899");
			empleado.setCorreoE("pablo@gmail.com");
			empleado.setSalario("456.553");
			drogueria.getListaEmpleado().add(empleado);
			
			empleado= new Empleado();
			empleado.setNombre("ana");
			empleado.setCedula("85611");
			empleado.setTelefono("9564722289");
			empleado.setCorreoE("ana@gmail.com");
			empleado.setSalario("645.899");
			drogueria.getListaEmpleado().add(empleado);
			
			
			Cliente cliente= new Cliente();
			cliente.setNombre("Fernando");
			cliente.setCedula("74658");
			cliente.setTelefono("6574839911");
			cliente.setCorreoE("fernando@gmail.com");
			cliente.setDireccion("armenia");
			drogueria.getListaClientes().add(cliente);
			
			cliente= new Cliente();
			cliente.setNombre("samuel");
			cliente.setCedula("35246");
			cliente.setTelefono("1324675940");
			cliente.setCorreoE("samuel@gmail.com");
			cliente.setDireccion("quimbaya");
			drogueria.getListaClientes().add(cliente);
			
			cliente= new Cliente();
			cliente.setNombre("rafael");
			cliente.setCedula("86557");
			cliente.setTelefono("3224153667");
			cliente.setCorreoE("rafael@gmail.com");
			cliente.setDireccion("buenaVista");
			drogueria.getListaClientes().add(cliente);
			
			Producto producto= new Producto();
			producto.setNombre("dolex");
			producto.setCodigo("64757");
			producto.setCantExis(6);
			producto.setValorU("1.000");
			drogueria.getListaProductos().add(producto);
			
			producto= new Producto();
			producto.setNombre("alcohol");
			producto.setCodigo("85647");
			producto.setCantExis(10);
			producto.setValorU("5.000");
			drogueria.getListaProductos().add(producto);
			
			producto= new Producto();
			producto.setNombre("gasas");
			producto.setCodigo("35462");
			producto.setCantExis(4);
			producto.setValorU("3.000");
			drogueria.getListaProductos().add(producto);
			
			
			Domicilio domicilio=new Domicilio();
			domicilio.setNumeroDomicilio("001");
			domicilio.setFecha("2022-04-14");
			domicilio.setCliente(drogueria.getListaClientes().get(0));
			domicilio.setProducto(drogueria.getListaProductos().get(0));
			domicilio.setEmpleado(drogueria.getListaEmpleado().get(0));
			domicilio.setDireccion("armenia");
			domicilio.setCosto(10000);
			drogueria.getListaDomicilios().add(domicilio);
			
			domicilio=new Domicilio();
			domicilio.setNumeroDomicilio("002");
			domicilio.setFecha("2022-04-15");
			domicilio.setCliente(drogueria.getListaClientes().get(1));
			domicilio.setProducto(drogueria.getListaProductos().get(1));
			domicilio.setEmpleado(drogueria.getListaEmpleado().get(1));
			domicilio.setDireccion("calarca");
			domicilio.setCosto(20000);
			drogueria.getListaDomicilios().add(domicilio);
			
			domicilio=new Domicilio();
			domicilio.setNumeroDomicilio("003");
			domicilio.setFecha("2022-04-16");
			domicilio.setCliente(drogueria.getListaClientes().get(2));
			domicilio.setProducto(drogueria.getListaProductos().get(2));
			domicilio.setEmpleado(drogueria.getListaEmpleado().get(2));
			domicilio.setDireccion("cordoba");
			domicilio.setCosto(30000);
			drogueria.getListaDomicilios().add(domicilio);
			
			System.out.println("Drogueria inicializada ");
		}

		public Drogueria getDrogueria() {
			return drogueria;
		}

		public void setDrogueria(Drogueria drogueria) {
			this.drogueria = drogueria;
		}

		//EMPLEADO
		@Override
		public Empleado crearEmpleado(String nombre, String cedula, String telefono, String correo, String salario) {

			Empleado empleado=null;
			try {
				empleado= getDrogueria().crearEmpleado(nombre, cedula, telefono, correo, salario);
			} catch (EmpleadoException e) {
				e.getMessage();
}
			return empleado;
		}

		@Override
		public Boolean eliminarEmpleado(String cedula) {
			boolean empleadoExiste= false;
			
			try {
				empleadoExiste= getDrogueria().eliminarEmpleado(cedula);
			} catch (EmpleadoException e) {
				e.getMessage();
			}
			
			return empleadoExiste;
		}

		@Override
		public Empleado obtenerEmpleado(String cedula) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Empleado> obtenerEmpleados() {
			return drogueria.getListaEmpleado();
		}

		@Override
		public boolean actualizarEmpleado(String cedulaActual, String nombre, String cedula, String telefono,
				String correo, String salario) {

			return drogueria.actualizarEmpleado(cedulaActual, nombre, cedula, telefono, correo, salario);
		}

		//CLIENTE
		@Override
		public Cliente crearCliente(String nombre, String cedula, String telefono, String correo, String direccion) {
			
			Cliente cliente=null;
			try {
				cliente= getDrogueria().crearCliente(nombre, cedula, telefono, correo, direccion);
			} catch (ClienteException e) {
				e.getMessage();
}
			return cliente;
		}

		@Override
		public Boolean eliminarCliente(String cedula) {
			
			boolean clienteExiste= false;
			
			try {
				clienteExiste= getDrogueria().eliminarCliente(cedula);
			} catch (ClienteException e) {
				e.getMessage();
			}
			
			return clienteExiste;
		}

		@Override
		public Cliente obtenerCliente(String cedula) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Cliente> obtenerClientes() {
			return drogueria.getListaClientes();
		}

		@Override
		public boolean actualizarCliente(String cedulaActual, String nombre, String cedula, String telefono,
				String correo, String direccion) {
			return drogueria.actualizarCliente(cedulaActual, nombre, cedula, telefono, correo, direccion);
		}

		//PRODUCTO
		@Override
		public Producto crearProducto(String nombre, String codigo, String valorU, int cantExis) {
			
			Producto producto=null;
			try {
				producto= getDrogueria().crearProducto(nombre, codigo, valorU, cantExis);
			} catch (ProductoException e) {
				e.getMessage();
}
			return producto;
		}

		@Override
		public Boolean eliminarProducto(String codigo) {
			
			boolean productoExiste= false;
			
			try {
				productoExiste= getDrogueria().eliminarProducto(codigo);
			} catch (ProductoException e) {
				e.getMessage();
			}
			
			return productoExiste;
		}

		@Override
		public Producto obtenerProducto(String codigo) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Producto> obtenerProducto() {
			return drogueria.getListaProductos();
		}

		@Override
		public boolean actualizarProducto(String codigoActual, String nombre, String codigo, String valorU,
				int cantExis) {
			return drogueria.actualizarProducto(codigoActual, nombre, codigo, valorU, cantExis);
		}
		

		
		//DOMICILIO
		@Override
		public Domicilio crearDomicilio(String numeroDomicilio, String fecha, Cliente cliente, Producto producto,
				Empleado empleado, String direccion, double costo) {
			Domicilio domicilio=null;
			try {
				domicilio= getDrogueria().crearDomicilio(numeroDomicilio, fecha,cliente,producto,empleado,direccion,costo);
			} catch (DomicilioException e) {
				e.getMessage();
			}	
			return domicilio;
		}

		@Override
		public Boolean eliminarDomicilio(String numeroDomicilio) {
			boolean domicilioExiste= false;
			
			try {
				domicilioExiste= getDrogueria().eliminarDomicilio(numeroDomicilio);
			} catch (DomicilioException e) {
				e.getMessage();
			}
			
			return domicilioExiste;
		}

		@Override
		public Domicilio obtenerDomicilio(String numeroDomicilio) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Domicilio> obtenerDomicilio() {
			return drogueria.getListaDomicilios();
		}

		@Override
		public boolean actualizarDomicilio(String numeroDomicilioActual, String numeroDomicilio, String fecha,
				Cliente cliente, Producto producto, Empleado empleado, String direccion, double costo) {
			return drogueria.actualizarDomicilio(numeroDomicilioActual,numeroDomicilio, fecha,cliente,producto,empleado,direccion,costo);
		}
		
		
		
		//XML
		public void guardarResourceXML() {
			hiloServicio1_Persistencia = new Thread(this);
			hiloServicio1_Persistencia.start();
			}
		public void cargarResourceXML() {
			drogueria= Persistencia.cargarRecursoDrogueriaXML();
			}
		//BINARIO
		public void cargarResourceBinario() {
			Persistencia.cargarRecursoDrogueriaBinario();
			}
		public void guardarResourceBinario() {
			Persistencia.guardarRecursoDrogueriaBinario(drogueria);
			}
		
		public void registrarAccioneSistema(String mensajeLog, int nivel, String accion) {
			hiloServicio2_RegistrarAcciones = new Thread(this);
			this.mensajeLog = mensajeLog;
			this.nivel = nivel;
			this.accion = accion;
			hiloServicio2_RegistrarAcciones.start();
		}
		
		
		//HILOS
		@Override
		public void run() {
			
			Thread hiloActual = Thread.currentThread();
			
			try {
				semaforo.ocupar();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			//1. hilo 1 para manejar la persistencia
			if(hiloActual == hiloServicio1_Persistencia){
				Persistencia.guardarRecursoDrogueriaXML(drogueria);
				try {
					semaforo.liberar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//2. hilo 2 para registrar las acciones del sistema
			if(hiloActual == hiloServicio2_RegistrarAcciones){
				Persistencia.guardaRegistroLog(mensajeLog, nivel, accion);
				try {
					semaforo.liberar();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		
		}

		
		
}
