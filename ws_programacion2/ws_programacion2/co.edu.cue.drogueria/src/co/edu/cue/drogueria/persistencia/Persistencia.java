package co.edu.cue.drogueria.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.drogueria.model.Cliente;
import co.edu.cue.drogueria.model.Drogueria;
import co.edu.cue.drogueria.model.Empleado;

public class Persistencia {
	
	public static final String RUTA_ARCHIVO_CLIENTES = "src/resources/archivoClientes.txt";
	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/resources/DrogueriaLog.txt";
	public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoProductos.txt";
	public static final String RUTA_ARCHIVO_MODELO_DROGUERIA_BINARIO = "src/resources/model.dat";
	public static final String RUTA_ARCHIVO_MODELO_DROGUERIA_XML = "C://td//persistencia//model.xml";
//	C:\td\persistencia

	
	
	public static void cargarDatosArchivos(Drogueria drogueria) throws FileNotFoundException, IOException {

		//cargar archivos empleados
		ArrayList<Empleado> empleadosCargados = cargarEmpleados();
		
		if(empleadosCargados.size() > 0)
			drogueria.getListaEmpleado().addAll(empleadosCargados);
		
		
		//cargar archivo de clientes
//		ArrayList<Cliente> clientesCargados = cargarClientes();
//		
//		if(clientesCargados.size() > 0)
//			banco.getListaClientes().addAll(clientesCargados);
		
		//cargar archivo objetos
		
		//cargar archivo empleados
		
		//cargar archivo prestamo
		
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
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, true);
		
	}
	
	
	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
		
		String contenido = "";
		
		for(Empleado empleado:listaEmpleados) 
		{
			contenido+= empleado.getNombre()+","+empleado.getCedula()+","+empleado.getTelefono()+","+empleado.getCorreoE()+","+empleado.getSalario()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, true);
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
			linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
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

	
	
	public static void guardarRecursoDrogueriaXML( Drogueria drogueria) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_DROGUERIA_XML, drogueria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
