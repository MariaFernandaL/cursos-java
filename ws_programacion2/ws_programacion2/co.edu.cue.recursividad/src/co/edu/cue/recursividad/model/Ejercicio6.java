package co.edu.cue.recursividad.model;

public class Ejercicio6 {

	public static void main(String[] args) {
		int [] array= {4,7,3,8,2,9};
		int posInicial=0;
		recorrerArray(array, posInicial);
	}

public static int recorrerArray(int array[], int posInicial){
		
		if (posInicial==array.length) {
			return 1;
		} else {
			System.out.println("El elemento en la posicion: "+posInicial+ " es: "+ array[posInicial]);
			return recorrerArray(array, posInicial+1);
		}
	}

}
