package hilo;

public class Hilo3 extends Thread{

	private boolean runHilo;
	private String nombreHilo3;
	
	
	public Hilo3() {
		
	}
	
	public void runHilo(String nombreHilo){
		runHilo= true;
		this.nombreHilo3=nombreHilo;
		this.start();
		
	}
	
	public void stopHilo(){
		runHilo=false;
	}
	
	@Override
	public void run() {
		while (runHilo==true) {
			for (int i = 0; i < 15; i++) {
				System.out.println("El nombre del hilo es: "+ nombreHilo3);
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			runHilo=false;
		}
	}
}