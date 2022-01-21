package co.edu.cue.drogueria.controller;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.drogueria.exception.EmpleadoException;
import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import co.edu.cue.drogueria.persistencia.Persistencia;
import co.edu.cue.drogueria.service.IModelFactoryController;

public class ModelFactoryController implements IModelFactoryController{

	Drogueria drogueria;
	
	
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

			inicializarDatos();
			
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
			
			/*
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
			*/
			System.out.println("Drogueria inicializada ");
		}

		public Drogueria getDrogueria() {
			return drogueria;
		}

		public void setDrogueria(Drogueria drogueria) {
			this.drogueria = drogueria;
		}

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
		
}
