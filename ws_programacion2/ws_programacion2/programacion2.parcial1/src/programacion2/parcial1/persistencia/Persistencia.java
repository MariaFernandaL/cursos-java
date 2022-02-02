package programacion2.parcial1.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import programacion2.parcial1.ejercicio1.Cliente;
import programacion2.parcial1.ejercicio1.Producto;

public class Persistencia {
	
	public static final String RUTA_ARCHIVO_CLIENTES= "../programacion2.parcial1/src/programacion2/parcial1/resources/archivoCliente.txt";
	public static final String RUTA_ARCHIVO_PRODUCTOS= "../programacion2.parcial1/src/programacion2/parcial1/resources/archivoProductos.txt";
	
	//GUARDAR ARCHIVO TXT EJERCICIO 1	
		public static void guardarClientes(ArrayList<Cliente> listaClientes) throws IOException {
			String contenido = "";
			
			for(Cliente cliente:listaClientes) 
			{
				contenido+= cliente.getCodigo()+"@"+cliente.getCedula()+"@"+cliente.getTipoIdentificacion()+"@"+cliente.getNombre()
			     +"@"+cliente.getApellido()+"@"+cliente.getTelefono()+"\n";
			}
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
			
		}
		
		public static void guardarProductos(ArrayList<Producto> listaProductos) throws IOException {
			String contenido = "";
			
			for(Producto producto:listaProductos) 
			{
				contenido+= producto.getCodigo()+"#"+producto.getNombre()+"#"+producto.getPrecio()+"#"+producto.getDescripcion()
			     +"#"+producto.getEstado()+"\n";
			}
			ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, false);
			
		}
}
