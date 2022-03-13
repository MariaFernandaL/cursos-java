package hilo;

public class ManejadorHilos implements Runnable{
	
	Thread hiloServicio1;
	Thread hiloServicio2;
	
	private int contador;
	private int numeroBase;
	
	public ManejadorHilos(){
		contador=1;
	}
	public void runHiloServicio1(int numeroBase) {
		hiloServicio1=new Thread(this);
		this.numeroBase= numeroBase;
		hiloServicio1.start();
	}
	
	public void runHiloServicio2() {
		hiloServicio2= new Thread(this);
		//aca se puede poner un if para q empieze antes o despues
		hiloServicio2.start();
	}
	@Override
	public void run() {
		
		Thread hiloActual= Thread.currentThread();
		
		if (hiloActual== hiloServicio1) {
			iniciarOperacionHiloServicio1();	
		}
		if (hiloActual== hiloServicio2) {
			iniciarOperacionHiloServicio2();
		}
	}
	
	private void iniciarOperacionHiloServicio1() {
		int resultado=0;
		
		while (contador<=10) {
			resultado= numeroBase*contador;
			System.out.println(numeroBase+ " X " + contador+ " = "+resultado);
			contador++;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void iniciarOperacionHiloServicio2() {
		int auxContador=1;
		
		while (auxContador<=3) {
			numeroBase= numeroBase+numeroBase;
			System.out.println("Numero base: "+ numeroBase);
			auxContador++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
}
