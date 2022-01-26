package hilo;

import javax.swing.JOptionPane;

public class Hilo2 extends Thread{

	private boolean runHilo;
	private String nombreHilo2;
	private int numero;
	private int multiplicacion;
	
	
	public Hilo2() {
		
	}
	
	public void runHilo(String nombreHilo){
		runHilo= true;
		this.nombreHilo2=nombreHilo;
		this.start();
	}
	
	public void stopHilo(){
		runHilo=false;
	}
	
	@Override
	public void run() {
		
		while (runHilo==true) {
			numero= Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero: "));
			for (int i = 0; i < 10; i++) {
				multiplicacion=numero*numero;
				System.out.println(numero+" * "+numero+"= "+multiplicacion+" "+nombreHilo2);
				numero=multiplicacion;
				
				try {
					sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/*try {
					this.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
			}
			runHilo=false;
		}
	}
}
