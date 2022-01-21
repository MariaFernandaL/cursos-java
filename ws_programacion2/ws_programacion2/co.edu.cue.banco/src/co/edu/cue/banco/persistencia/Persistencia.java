package co.edu.cue.banco.persistencia;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.banco.exception.UsuarioExcepcion;
import co.edu.cue.banco.model.Banco;
import co.edu.cue.banco.model.Cliente;
import co.edu.cue.banco.model.Empleado;
import co.edu.cue.banco.model.Usuario;

public class Persistencia {

	public static final String RUTA_ARCHIVO_CLIENTES = "src/resources/archivoClientes.txt";
	public static final String RUTA_ARCHIVO_EMPLEADOS = "src/resources/archivoEmpleados.txt";
	public static final String RUTA_ARCHIVO_USUARIOS = "src/resources/archivoUsuarios.txt";
	public static final String RUTA_ARCHIVO_LOG = "src/resources/BancoLog.txt";
	public static final String RUTA_ARCHIVO_OBJETOS = "src/resources/archivoObjetos.txt";
	public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/resources/model.dat";
	public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "C://td//persistencia//model.xml";
//	C:\td\persistencia

	
	
	public static void cargarDatosArchivos(Banco banco) throws FileNotFoundException, IOException {

		//cargar archivos empleados
		ArrayList<Empleado> empleadosCargados = cargarEmpleados();
		
		if(empleadosCargados.size() > 0)
			banco.getListaEmpleados().addAll(empleadosCargados);
		
		
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
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Cliente cliente:listaClientes) 
		{
			contenido+= cliente.getNombre()+","+cliente.getApellido()+","+cliente.getCedula()+","+cliente.getDireccion()
		     +","+cliente.getCorreo()+","+cliente.getFechaNacimiento()+","+cliente.getTelefono()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
		
	}
	
	
	public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
		
		// TODO Auto-generated method stub
		String contenido = "";
		
		for(Empleado empleado:listaEmpleados) 
		{
			contenido+= empleado.getNombre()+","+empleado.getApellido()+","+empleado.getCedula()+","+empleado.getFechaNacimiento()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
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
			cliente.setApellido(linea.split(",")[1]);
			cliente.setCedula(linea.split(",")[2]);
			cliente.setDireccion(linea.split(",")[3]);
			cliente.setCorreo(linea.split(",")[4]);
			cliente.setFechaNacimiento(linea.split(",")[5]);
			cliente.setTelefono(linea.split(",")[6]);
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
			empleado.setApellido(linea.split(",")[1]);
			empleado.setCedula(linea.split(",")[2]);
			empleado.setFechaNacimiento(linea.split(",")[3]);
			empleados.add(empleado);
		}
		return empleados;
		
		
	}
	
	


	public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
	{
		
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}


	public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioExcepcion {
		
		if(validarUsuario(usuario,contrasenia)) {
			return true;
		}else {
			throw new UsuarioExcepcion("Usuario no existe");
		}
	}
	
	private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException 
	{
		ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);
		
		for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++) 
		{
			Usuario usuarioAux = usuarios.get(indiceUsuario);
			if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
		ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
		String linea="";
		
		for (int i = 0; i < contenido.size(); i++) {
			linea = contenido.get(i);
			
			Usuario usuario = new Usuario();
			usuario.setUsuario(linea.split(",")[0]);
			usuario.setContrasenia(linea.split(",")[1]);
			
			usuarios.add(usuario);
		}
		return usuarios;
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
			contenido+= clienteAux.getNombre()+","+clienteAux.getApellido()+","+clienteAux.getCedula()+clienteAux.getDireccion()
					     +","+clienteAux.getCorreo()+","+clienteAux.getFechaNacimiento()+","+clienteAux.getTelefono()+"\n";
		}
		ArchivoUtil.guardarArchivo(ruta, contenido, true);
	}


	
	
	
	//------------------------------------SERIALIZACIÓN  y XML
	
	
	public static Banco cargarRecursoBancoBinario() {
		
		Banco banco = null;
		
		try {
			banco = (Banco)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banco;
	}
	
	public static void guardarRecursoBancoBinario(Banco banco) {
		
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, banco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Banco cargarRecursoBancoXML() {
		
		Banco banco = null;
		
		try {
			banco = (Banco)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return banco;

	}

	
	
	public static void guardarRecursoBancoXML(Banco banco) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, banco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
