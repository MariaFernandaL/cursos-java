package co.edu.cue.preParcial1.Ejercicio3Hilos2;

public class ManejadorHilos implements Runnable{

	
	Thread hilo1;
	Thread hilo2;
	
	public void run() {
		
		//verificar que hilo se esta ejecutando
		Thread hiloActual = Thread.currentThread();
		
		if(hiloActual == hilo1){
//			imprimir pares
		}
		
		if(hiloActual == hilo2){
//			imprimir impares
		}

	};

}
