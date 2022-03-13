package co.edu.cue.preParcial1.Ejercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.cue.preParcial1.persistencia.Persistencia;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		ArrayList<Estudiante> listaEstudiantes= new ArrayList<>();
		Estudiante estudiante= new Estudiante(JOptionPane.showInputDialog("Digite el codigo del estudiante"), JOptionPane.showInputDialog("Digite el nombre del estudiante"), JOptionPane.showInputDialog("Digite la nota 1 del estudiante"), JOptionPane.showInputDialog("Digite la nota 2 del estudiante"), JOptionPane.showInputDialog("Digite la nota 3 del estudiante"));
		Estudiante estudiante2= new Estudiante(JOptionPane.showInputDialog("Digite el codigo del estudiante"), JOptionPane.showInputDialog("Digite el nombre del estudiante"), JOptionPane.showInputDialog("Digite la nota 1 del estudiante"), JOptionPane.showInputDialog("Digite la nota 2 del estudiante"), JOptionPane.showInputDialog("Digite la nota 3 del estudiante"));
		Estudiante estudiante3= new Estudiante(JOptionPane.showInputDialog("Digite el codigo del estudiante"), JOptionPane.showInputDialog("Digite el nombre del estudiante"), JOptionPane.showInputDialog("Digite la nota 1 del estudiante"), JOptionPane.showInputDialog("Digite la nota 2 del estudiante"), JOptionPane.showInputDialog("Digite la nota 3 del estudiante"));
		listaEstudiantes.add(estudiante);
		listaEstudiantes.add(estudiante2);
		listaEstudiantes.add(estudiante3);
		for (Estudiante estudiante1 : listaEstudiantes) {
			System.out.println(estudiante1);
		}
		try {
			Persistencia.guardarEstudiantes(listaEstudiantes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//BUSCAR ESTUDIANTE
		
		String codigoE=JOptionPane.showInputDialog("Digite el codigo del estudiante que desea buscar");
		Estudiante estudianteBuscar= null;
		for (Estudiante estudianteBuscar1 : listaEstudiantes) {
			if (estudianteBuscar1.getCodigo().equalsIgnoreCase(codigoE)) {
				estudianteBuscar=estudianteBuscar1;
				break;
			}
		}
		System.out.println("Los datos del estudiante son: "+estudianteBuscar);
	}
	
	
	
}
