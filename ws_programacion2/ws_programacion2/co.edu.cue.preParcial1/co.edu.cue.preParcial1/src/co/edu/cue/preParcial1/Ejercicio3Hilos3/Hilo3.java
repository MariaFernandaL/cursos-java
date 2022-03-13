package co.edu.cue.preParcial1.Ejercicio3Hilos3;

public class Hilo3 extends Thread{

	private boolean runHilo;
	int contador=0;
	
	public Hilo3(){
		
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
		
		contarCaracteres("otorrinolaringologo",0);
	}

	private void contarCaracteres(String cadena, int i) {
		String c;
		if (i==cadena.length()-1) {
			c=String.valueOf(cadena.charAt(i));
			verificarConsonante(c);
		} else {
			c= String.valueOf(cadena.charAt(i));
			verificarConsonante(c);
			contarCaracteres(cadena, i+1);
		}
		
	}

	private void verificarConsonante(String c) {

		if (c.equals("a") || c.equals("e") || c.equals("i") || c.equals("o") || c.equals("u")) {
			
		}else {
			setContador(getContador()+1);
		}
	}

	public boolean isRunHilo() {
		return runHilo;
	}

	public void setRunHilo(boolean runHilo) {
		this.runHilo = runHilo;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
	
}
