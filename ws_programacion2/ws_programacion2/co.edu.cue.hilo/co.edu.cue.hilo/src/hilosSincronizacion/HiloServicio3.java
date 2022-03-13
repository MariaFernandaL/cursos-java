package hilosSincronizacion;

public class HiloServicio3 extends Thread{
	
	private boolean runHilo;
	private int contador = 1;
	private String nombreHilo;
	
	public HiloServicio3() {
		
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
			
			
			
		}
	}

	
}
