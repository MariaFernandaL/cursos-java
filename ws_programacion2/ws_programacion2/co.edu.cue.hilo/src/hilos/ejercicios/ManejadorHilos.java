package hilos.ejercicios;

import java.util.concurrent.Semaphore;

public class ManejadorHilos implements Runnable{

	
	private String variable;
	private Semaphore semaforo = new Semaphore(1);
	
	
	Thread hiloServicio1;
	Thread hiloServicio2;
	
	public ManejadorHilos() {
		
	}
	
	public void runHiloServicio1() {
		hiloServicio1=new Thread(this);
		hiloServicio1.start();
	}
	
	public void runHiloServicio2() {
		hiloServicio2= new Thread(this);
		hiloServicio2.start();
	}
	
	@Override
	public void run() {
		
		Thread hiloActual= Thread.currentThread();
		Long tiempoActual= System.currentTimeMillis();//hora actual del sistema en milisegundos
		Long tiempoFinal= tiempoActual+20000;
		while (tiempoActual<tiempoFinal) {
			try {
				semaforo.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		
			if (hiloActual== hiloServicio1) {
				iniciarOperacionHiloServicio1();
				semaforo.release();
				}	
					
			if (hiloActual== hiloServicio2) {
				iniciarOperacionHiloServicio2();
				semaforo.release();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tiempoActual= System.currentTimeMillis();
		}
	}
	
	
	private void iniciarOperacionHiloServicio1() {
		variable= "";
		Long tiempoActual= System.currentTimeMillis();//hora actual del sistema en milisegundos
		
		Long tiempoFinal= tiempoActual+6000;
		
		
		while (tiempoActual < tiempoFinal) {
			
			//System.out.println("Tiempo Actual= "+tiempoActual);
				variable= variable+"-hola";
				System.out.println(" Hilo1    "+variable);
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tiempoActual= System.currentTimeMillis();
			
			//System.out.println("Tiempo Actual = "+ tiempoActual);
			//System.out.println("Tiempo Final = "+ tiempoFinal);
		}
	}


	private void iniciarOperacionHiloServicio2() {
		
		System.out.println("Hilo2. Ahora variable tiene: "+ variable);
		variable="";
		System.out.println("Hilo2. Variable ELIMINADA: "+variable);	
		
	}
	
	
	
	
	
	
}
