package co.edu.cue.recursividad.model;


public class Ejercicio9 {

	public static void main(String[] args) {
		
		int matriz [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int i=0;
		int j=0;
		int filas= matriz.length;
		int columnas= matriz[i].length;
		
		System.out.println("La suma de la diagonal de la matriz es: "+sumarDiagonalMatriz(matriz, i, j, filas, columnas));
	}

	//9 
	public static int sumarDiagonalMatriz(int matriz[][], int i, int j, int filas, int columnas){
		int sumaDiagonal=0;
		if (i==j) {
			sumaDiagonal=sumaDiagonal+matriz[i][j];
			sumarDiagonalMatriz(matriz, sumaDiagonal, j, filas, columnas);
		} else {
			return sumarDiagonalMatriz(matriz, sumaDiagonal, j, filas, columnas);
		}
		return 0;
		
		/*
		if (i<filas) {
			if (j<columnas) {
				//System.out.print(matriz[i][j]);
				sumaDiagonal=sumaDiagonal+matriz[i][j];
				sumarDiagonalMatriz(matriz, i+1, j+1, filas, columnas);
				return sumaDiagonal;
			} else {
				System.out.println("La suma no se puede hacer");
			}
		}
		return 0;*/
	}
	
}
