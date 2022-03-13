package co.edu.cue.preParcial1.Ejercicio3Hilos3;

public class Hilo1 extends Thread{

	private boolean runHilo;
	int valor;
	
	public Hilo1(){
		
	}
	
	public void runHilo(){
		runHilo=true;
		this.start();
	}
	public void stopHilo(){
		runHilo=false;
	}
	
	@Override
	public void run() {
		System.out.println("Numeros creados al azar: ");
		valor= sumaEnteros(0,10,1);
	}

	private int sumaEnteros(int entero, int n, int i) {
		entero= (int) (Math.random()*10+1);
		System.out.println("El numero "+ i+ " es: "+entero);
		if (i==n) {
			return entero;
		} else {
			return sumaEnteros(entero, n, i+1)+entero;
		}
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isRunHilo() {
		return runHilo;
	}

	public void setRunHilo(boolean runHilo) {
		this.runHilo = runHilo;
	}

}
