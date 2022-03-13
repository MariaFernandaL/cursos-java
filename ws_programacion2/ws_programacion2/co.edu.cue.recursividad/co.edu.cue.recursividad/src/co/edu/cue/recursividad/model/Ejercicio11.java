package co.edu.cue.recursividad.model;

public class Ejercicio11 {

	public static void main(String[] args) {
		int matriz [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int i=0;
		int j=matriz[0].length;
		System.out.println("El resultado de la suma de la matriz es: "+sumarElementosMatriz(matriz,i,j));

	}
	
	private static int sumarElementosMatriz(int[][] matriz, int i, int j) {
		
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
}
