package co.edu.cue.preParcial1.Ejercicio3Hilos3;

public class Hilo2 extends Thread{

	private boolean runHilo;
	int valor;
	
	public Hilo2(){
		
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
		valor=calcularFactorial(4); 
	}
	
	
	private int calcularFactorial(int i) {
		
		if (i==1 || i==0) {
			return i;
		}else {
			return calcularFactorial(i-1)*i;
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
