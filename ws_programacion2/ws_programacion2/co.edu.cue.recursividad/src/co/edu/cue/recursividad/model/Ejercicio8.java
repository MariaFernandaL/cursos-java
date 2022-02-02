package co.edu.cue.recursividad.model;

public class Ejercicio8 {

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
		
		recorrerMatriz(matriz, i, j, filas, columnas);
	}
	public static int recorrerMatriz(int matriz[][], int i, int j, int filas, int columnas){

		if (i<filas) {
			if (j<columnas) {
				System.out.print(matriz[i][j]+" ");
				recorrerMatriz(matriz, i, j+1, filas, columnas);
			}
			if (j==columnas) {
				System.out.println("");
				recorrerMatriz(matriz, i+1, 0, filas, columnas);
			}
		}
		return 0;
	}

}
