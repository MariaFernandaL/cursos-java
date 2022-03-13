package co.edu.cue.recursividad.model;


public class Ejercicio9 {

	public static void main(String[] args) {
		
		int matriz [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int i=3;
		int j=3;
		
		System.out.println("La suma de la diagonal de la matriz es: "+sumarDiagonalMatriz(matriz, i, j));
	}

	//9 
	public static int sumarDiagonalMatriz(int matriz[][], int i, int j){
		 if (i > 0) { 
		        if (j > 0) 
		        {
		        	if((i-1) == (j-1))
		        		return matriz[i - 1][j - 1] + sumarDiagonalMatriz(matriz, i, --j);
		        	else
		        		return sumarDiagonalMatriz(matriz, i, --j);
		        }
		        else 
		        { 
		            return sumarDiagonalMatriz(matriz, --i, j + matriz[i].length); 
		        } 
		    } 
		    else { 
		        return 0; 
		    }
	}
	
}
