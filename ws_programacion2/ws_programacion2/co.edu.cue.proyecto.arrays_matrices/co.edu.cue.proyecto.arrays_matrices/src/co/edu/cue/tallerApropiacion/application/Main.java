package co.edu.cue.tallerApropiacion.application;

import co.edu.cue.tallerApropiacion.model.EjercicioApropiacion;

public class Main {


	public static void main(String[] args) {
		
		EjercicioApropiacion miEjercicio= new EjercicioApropiacion();
		
		miEjercicio.ejercicio1();
		miEjercicio.ejercicio2();
		miEjercicio.ejercicio3();
		miEjercicio.ejercicio4();
		miEjercicio.ejercicio5();
		miEjercicio.ejercicio6();
		
		EjercicioApropiacion miEjercicio2Mat= new EjercicioApropiacion();
		
		miEjercicio2Mat.matriz1();
		miEjercicio2Mat.ejercicio2Matriz();
		miEjercicio2Mat.ejercicio5Matriz();
		miEjercicio2Mat.ejercicio6Matriz();
	}
}
