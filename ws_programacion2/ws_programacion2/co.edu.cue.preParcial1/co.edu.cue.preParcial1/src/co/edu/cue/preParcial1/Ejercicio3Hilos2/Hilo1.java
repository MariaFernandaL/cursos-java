package co.edu.cue.preParcial1.Ejercicio3Hilos2;

public class Hilo1 extends Thread{

	public Hilo1() {

	}
	

	@Override
	public void run() {
		imprimirNumerosPares(0);
	}
	
	private void imprimirNumerosPares(int n) {
		
		if (n<=100) {
			if (n%2==0) {
				System.out.println(n);
				imprimirNumerosPares(n+1);
			} else {
				imprimirNumerosPares(n+1);
			}
		}
	}
}
