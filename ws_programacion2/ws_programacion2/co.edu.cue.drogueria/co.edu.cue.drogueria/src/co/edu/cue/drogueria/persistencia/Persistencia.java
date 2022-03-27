package co.edu.cue.drogueria.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;
import co.edu.cue.drogueria.model.Producto;
import co.edu.cue.drogueria.model.Domicilio;

public class Persistencia {
	
	public static final String RUTA_ARCHIVO_CLIENTES = "src/resources/archivoClientes.txt";
	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/resources/DrogueriaLog.txt";
	public static final String RUTA_ARCHIVO_PRODUCTOS = "src/resources/archivoProductos.txt";
	public static final String RUTA_ARCHIVO_DOMICILIOS = "src/resources/archivoDomicilos.txt";
	public static final String RUTA_ARCHIVO_MODELO_DROGUERIA_BINARIO = "src/resources/model.dat";
	public static final String RUTA_ARCHIVO_MODELO_DROGUERIA_XML = "src/resources/model.xml";

	
	
	public static void cargarDatosArchivos(Drogueria drogueria) throws FileNotFoundException, IOException {

		//cargar archivos empleados
		ArrayList<Empleado> empleadosCargados = cargarEmpleados();
		
		if(empleadosCargados.size() > 0)
			drogueria.getListaEmpleado().addAll(empleadosCargados);
		
		
		//cargar archivo de clientes
		ArrayList<Cliente> clientesCargados = cargarClientes();
		
		if(clientesCargados.size() > 0)
			drogueria.getListaClientes().addAll(clientesCargados);
		
		//cargar archivo productos
		ArrayList<Producto> productosCargados = cargarProductos();
		
		if(productosCargados.size() > 0)
			drogueria.getListaProductos().addAll(productosCargados);		
	}

	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	
	public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
		String contenido = "";
		
		for(Cliente cliente:listaClientes) 
		{
			contenido+= cliente.getNombre()+","+cliente.getCedula()+","+cliente.getDireccion()+","+cliente.getCorreoE()
		     +","+cliente.getTelefono()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
		
	}
	
	
	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
		
		String contenido = "";
		
		for(Empleado empleado:listaEmpleados) 
		{
			contenido+= empleado.getNombre()+","+empleado.getCedula()+","+empleado.getTelefono()+","+empleado.getCorreoE()+","+empleado.getSalario()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
	}
	
public static void guardarProductos(ArrayList<Producto> listaProductos) throws IOException {
		
		String contenido = "";
		
		for(Producto producto:listaProductos) 
		{
			contenido+= producto.getNombre()+","+producto.getCodigo()+","+producto.getValorU()+","+producto.getCantExis()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
	}
	
	
//	----------------------LOADS------------------------
	
	/**
	 * 
	 * @param tipoPersona
	 * @param ruta
	 * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public static ArrayList<Cliente> cargarClientes() throws FileNotFoundException, IOException 
	{
		ArrayList<Cliente> clientes =new ArrayList<Cliente>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Cliente cliente = new Cliente();
			cliente.setNombre(linea.split(",")[0]);
			cliente.setCedula(linea.split(",")[1]);
			cliente.setDireccion(linea.split(",")[2]);
			cliente.setCorreoE(linea.split(",")[3]);
			cliente.setTelefono(linea.split(",")[4]);
			clientes.add(cliente);
		}
		return clientes;
	}
	
	
	private static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {

		ArrayList<Empleado> empleados =new ArrayList<Empleado>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Empleado empleado = new Empleado();
			empleado.setNombre(linea.split(",")[0]);
			empleado.setCedula(linea.split(",")[1]);
			empleado.setTelefono(linea.split(",")[2]);
			empleado.setCorreoE(linea.split(",")[3]);
			empleado.setSalario(linea.split(",")[4]);
			empleados.add(empleado);
		}
		return empleados;
		
		
	}
	private static ArrayList<Producto> cargarProductos() throws FileNotFoundException, IOException {

		ArrayList<Producto> productos =new ArrayList<Producto>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PRODUCTOS);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			Producto producto = new Producto();
			producto.setNombre(linea.split(",")[0]);
			producto.setCodigo(linea.split(",")[1]);
			producto.setValorU(linea.split(",")[2]);
			producto.setCantExis(Integer.parseInt(linea.split(",")[3]));
			productos.add(producto);
		}
		return productos;
		
		
	}
	
	

	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


	
	

//	----------------------SAVES------------------------
	
	/**
	 * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
	 * @param objetos
	 * @param ruta
	 * @throws IOException
	 */
	
	public static void guardarObjetos(ArrayList<Cliente> listaClientes, String ruta) throws IOException  {
		String contenido = "";
		
		for(Cliente clienteAux:listaClientes) {
			contenido+= clienteAux.getNombre()+","+clienteAux.getCedula()+","+clienteAux.getTelefono()+clienteAux.getCorreoE()
					     +","+clienteAux.getDireccion()+"\n";
		}
		ArchivoUtil.guardarArchivo(ruta, contenido, true);
	}


	
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
	public static Drogueria cargarRecursoDrogueriaBinario() {
		
		Drogueria drogueria = null;
		
		try {
			drogueria = (Drogueria)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_DROGUERIA_BINARIO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drogueria;
	}
	
	public static void guardarRecursoDrogueriaBinario(Drogueria drogueria) {
		
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_DROGUERIA_BINARIO, drogueria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Drogueria cargarRecursoDrogueriaXML() {
		
		Drogueria drogueria = null;
		
		try {
			drogueria = (Drogueria)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_DROGUERIA_XML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drogueria;

	}

	
	
	public static void guardarRecursoDrogueriaXML(Drogueria drogueria) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_DROGUERIA_XML, drogueria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
