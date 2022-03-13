package co.edu.cue.preParcial1.Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import co.edu.cue.preParcial1.persistencia.Persistencia;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Universidad universidad= null;
		universidad= inicializarDatos(universidad);
		crearPrograma(universidad.getListaFacultades().get(0));
		Persistencia.guardarRecursoUniversidadXML(universidad);
	}	

	
	private static void crearPrograma(Facultad facultad) {

		String modalidadSeleccionada= "";
		
		Programa programa= new Programa();
		programa.setNombreP(JOptionPane.showInputDialog("Ingrese el nombre del programa"));
		programa.setCodigoP(JOptionPane.showInputDialog("Ingrese el codigo del programa"));
	
		modalidadSeleccionada=obtenerModalidad();
		programa.setModalidad(modalidadSeleccionada);
		facultad.getListaProgramas().add(programa);
		System.out.println(programa.toString());
		
		programa= new Programa();
		programa.setNombreP(JOptionPane.showInputDialog("Ingrese el nombre del programa"));
		programa.setCodigoP(JOptionPane.showInputDialog("Ingrese el codigo del programa"));
	
		modalidadSeleccionada=obtenerModalidad();
		programa.setModalidad(modalidadSeleccionada);
		facultad.getListaProgramas().add(programa);
		
		System.out.println(programa.toString());
		
		String codigo= JOptionPane.showInputDialog("Digite el codigo del programa que desea buscar");
		Programa buscarPrograma= buscarPrograma(codigo, facultad.getListaProgramas());
		System.out.println("El programa buscado es: "+ buscarPrograma.toString());
	}

	private static Programa buscarPrograma(String codigo, ArrayList<Programa> listaProgramas) {
		Programa programaBuscar= null;
		for (Programa programa : listaProgramas) {
			if (programa.getCodigoP().equalsIgnoreCase(codigo)) {
				programaBuscar=programa;
				break;
			}
		}
		return programaBuscar;
	}

	
	
	private static String obtenerModalidad() {
		ArrayList<String> listaModalidades=null;
		String modalidadSeleccionada="";
		
		try {
			listaModalidades=Persistencia.cargarModalidadades();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Lista de modalidades disponible: ");
		
		for (int i = 0; i < listaModalidades.size(); i++) {
			System.out.println(i+". "+listaModalidades.get(i));
		}
		
		modalidadSeleccionada=leerStringConsola("Escriba el nombre de la modalidad");
		return modalidadSeleccionada;
	}

	
	
	
	
	
	
	private static String leerStringConsola(String mensaje) {
		String captura="";
		System.out.println(mensaje);
		Scanner teclado= new Scanner(System.in);
		captura= teclado.nextLine();
		return captura;
	}

	private static Universidad inicializarDatos(Universidad universidad) {
		universidad= new Universidad("Universidad del Quindio");
		System.out.println(universidad.toString());
		Facultad facultad= new Facultad(JOptionPane.showInputDialog("Ingrese la facultad a la que pertenece: "));
		System.out.println(facultad.toString());
		universidad.getListaFacultades().add(facultad);
		
		return universidad;
	}

}
