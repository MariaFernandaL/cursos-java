package co.edu.cue.preParcial1.Ejercicio3Hilos2;

public class MainHilo {

	public static void main(String[] args) {
		
		Hilo1 hilo1= new Hilo1();
		hilo1.start();
		Hilo2 hilo2= new Hilo2();
		hilo2.start();
	}
}
