package co.edu.cue.preParcial1.Ejercicio3Hilos3;

public class Main {

	public static void main(String[] args) {
		
		Hilo1 hilo1= new Hilo1();
		Hilo2 hilo2= new Hilo2();
		Hilo3 hilo3= new Hilo3();

		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		
		try {
			hilo1.join();
			hilo2.join();
			hilo3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		int d= hilo1.getValor()*hilo2.getValor();
		System.out.println("D es igual a: "+d);
		
		int consonantes= hilo3.getContador();
		System.out.println("La palabra ingresada tiene: "+consonantes+ " consonantes");

	}

}
