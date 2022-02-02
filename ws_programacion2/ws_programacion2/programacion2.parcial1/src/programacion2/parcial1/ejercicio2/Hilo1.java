package programacion2.parcial1.ejercicio2;

public class Hilo1 extends Thread{

	private boolean runHilo;
	int [] array= {1,2,0,3,0,0,1,0};
	int elementoBuscar=0;
	int n2=0;
	
	public Hilo1(){
		
	}
	
	public void runHilo(){
		runHilo=true;
		this.run();
	}
	public void stopHilo(){
		runHilo=false;
	}
	
	@Override
	public void run() {
		System.out.println("La cantidad de 0 en el arreglo son: "+contarCerosArreglo(array, elementoBuscar,n2));
	}

	private int contarCerosArreglo(int [] array,int valor,int posInici) {
		 int contador=0;
			if(posInici<array.length){
				if(valor==array[posInici]){
					contador=1+contarCerosArreglo(array, valor, posInici+1);
					return contador;
					} else {
						contador=0+contarCerosArreglo(array, valor, posInici+1);
						return contador;
						}
				} 
			return 0;
	}

	
	public boolean isRunHilo() {
		return runHilo;
	}

	public void setRunHilo(boolean runHilo) {
		this.runHilo = runHilo;
	}
	
	
}
