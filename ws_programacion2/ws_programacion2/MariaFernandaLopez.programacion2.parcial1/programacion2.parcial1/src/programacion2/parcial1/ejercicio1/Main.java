package programacion2.parcial1.ejercicio1;

import java.util.ArrayList;

import programacion2.parcial1.persistencia.Persistencia;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Cliente> listaCliente= new ArrayList<>();
		listaCliente= inicializarDatosCliente(listaCliente);
		
		ArrayList<Producto> listaProductos=new ArrayList<>();
		listaProductos= inicializarDatosProducto(listaProductos);
		
		try {
			Persistencia.guardarClientes(listaCliente);
			Persistencia.guardarProductos(listaProductos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	private static ArrayList<Cliente> inicializarDatosCliente(ArrayList<Cliente> listaCliente) {
		Cliente cliente1= new Cliente("8290389", "98908878", "C.C", "Paola", "Perez", "32833892983");
		listaCliente.add(cliente1);
		System.out.println(cliente1.toString());
		
		Cliente cliente2= new Cliente("8789080", "327128937", "C.C", "Maria", "Lopez", "976687987");
		listaCliente.add(cliente2);
		System.out.println(cliente2.toString());
		
		return listaCliente;
	}
	
	
	private static ArrayList<Producto> inicializarDatosProducto(ArrayList<Producto> listaProducto) {
		Producto producto= new Producto("79877", "Arroz", 3000, "producto basico para el hogar", "disponible");
		listaProducto.add(producto);
		System.out.println(producto.toString());
		
		producto= new Producto("8748927", "Panela", 4000, "producto basico para el hogar", "no disponible");
		listaProducto.add(producto);
		System.out.println(producto.toString());
		
		producto= new Producto("97489324", "Frijoles", 2000, "producto basico para el hogar", "disponible");
		listaProducto.add(producto);
		System.out.println(producto.toString());
		
		return listaProducto;
	}
	

}
