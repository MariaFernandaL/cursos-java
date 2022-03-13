package programacion2.parcial1.ejercicio2;

import java.util.ArrayList;

public class MainHilos {

	public static void main(String[] args) {
		
		
		obtenerProductos();
		
		
		Hilo1 hilo1= new Hilo1();
		hilo1.runHilo();

		Hilo2 hilo2= new Hilo2();
		hilo2.runHilo();
		
		
		try {
			hilo1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void obtenerProductos() {
		ArrayList<String> listaProductos=null;
		
		try {
			listaProductos=programacion2.parcial1.persistencia.Persistencia.cargarProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Lista de productos disponible: ");
		
		for (int i = 0; i < listaProductos.size(); i++) {
			System.out.println(i+". "+listaProductos.get(i));
		}
		
	}
}
