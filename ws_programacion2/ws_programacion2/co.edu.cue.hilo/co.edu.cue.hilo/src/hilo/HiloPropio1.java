package hilo;

public class HiloPropio1 extends Thread{
	
	private boolean runHilo;
	private String nombreHilo;
	
	int [] lista= new int[10];
	
	
	public HiloPropio1() {

	}
	
	public void runHilo(String nombreHilo){
		runHilo= true;
		this.nombreHilo=nombreHilo;
		this.start();
	}
	
	public void stopHilo(){
		runHilo=false;
	}
	
	@Override
	public void run() {
		while (runHilo==true) {
			for (int i = 0; i < lista.length; i++) {
				lista[i]= i;
				System.out.println("Arreglo: "+lista[i]+ " "+nombreHilo);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			runHilo=false;
		}
	}

}
