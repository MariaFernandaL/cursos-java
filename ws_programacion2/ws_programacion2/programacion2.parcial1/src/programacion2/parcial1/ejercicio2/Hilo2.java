package programacion2.parcial1.ejercicio2;

public class Hilo2 extends Thread {

	private boolean runHilo;
	
	int matriz [][] = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
	};
	int i=0;
	int j=matriz[0].length;
	
	public Hilo2(){
		
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
		System.out.println("El resultado de la suma de la matriz es: "+sumarElementosMatriz(matriz,i,j));
	}
	
	private int sumarElementosMatriz(int[][] matriz, int i, int j) {
		if (i != matriz.length) { 
	        if (j > 0) {
	            return matriz[i][j - 1] + sumarElementosMatriz(matriz, i, --j); 
	        } else {
	        	j = matriz[i].length;
	            return sumarElementosMatriz(matriz, ++i, j); 
	        } 
	    } else { 
	        return 0; 
	    }
	}

	public boolean isRunHilo() {
		return runHilo;
	}

	public void setRunHilo(boolean runHilo) {
		this.runHilo = runHilo;
	}
}






