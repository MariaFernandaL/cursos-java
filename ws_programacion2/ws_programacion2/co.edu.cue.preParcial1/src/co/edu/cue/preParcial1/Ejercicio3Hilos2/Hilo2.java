package co.edu.cue.preParcial1.Ejercicio3Hilos2;

public class Hilo2 extends Thread{

	public Hilo2() {

	}
	
	
	
	@Override
	public void run() {
		imprimirNumerosImPares(0);
		//imprima los numeros impares
	}
	
private void imprimirNumerosImPares(int n) {
		
		if (n<=100) {
			if (n%2==0) {
				imprimirNumerosImPares(n+1);
			} else {
				System.out.println(n);
				imprimirNumerosImPares(n+1);
			}
		}
	}

}
