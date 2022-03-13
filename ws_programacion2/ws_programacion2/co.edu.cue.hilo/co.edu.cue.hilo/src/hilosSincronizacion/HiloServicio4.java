package hilosSincronizacion;

public class HiloServicio4 extends Thread{
	
	private boolean runHilo;
	private int contador = 1;
	private String nombreHilo;
	
	public HiloServicio4() {
		
	}
	
	public void runHilo(String nombreHilo){
		runHilo = true;
		this.nombreHilo = nombreHilo;
		this.start();
	}
	
	public void stopHilo() {
		runHilo = false;
	}
	
	@Override
	public void run() {

		while (runHilo == true) {
			System.out.println("Contador 2 = "+contador+ " "+ nombreHilo);
			
			if(contador == 50){
				runHilo = false;
				contador = 1;
			}
			contador++;
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
