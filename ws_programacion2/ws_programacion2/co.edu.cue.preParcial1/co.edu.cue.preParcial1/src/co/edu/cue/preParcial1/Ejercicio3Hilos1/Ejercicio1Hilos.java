package co.edu.cue.preParcial1.Ejercicio3Hilos1;

import javax.swing.JOptionPane;

public class Ejercicio1Hilos {

	public static void main(String[] args) {
		

		HiloNumerosLetras hilo1= new HiloNumerosLetras(1);
		HiloNumerosLetras hilo2= new HiloNumerosLetras(2);
		
		hilo1.runHilo("Mostrar Numeros y Letras");
		hilo2.runHilo("Mostrar Numeros y Letras");
		
		/*
		Thread t1= new Thread(hilo1);
		Thread t2= new Thread(hilo2);
		
		t1.start();
		t2.start();*/
	}

}
