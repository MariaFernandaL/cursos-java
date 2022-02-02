package co.edu.cue.recursividad.model;

public class Ejercicio7 {

	public static void main(String[] args) {

		int [] array= {4,7,3,8,2,9};
		int posInicial=0;
		int elemento=8;
		
		System.out.println("La posicion en la que se encuentra el numero 8 es: "+ buscarElemento(array, posInicial, elemento));
		
	}
	public static int buscarElemento(int array[], int posInicial, int elemento){
		int posicionElemento;
		if (posInicial<array.length) {
			if (elemento== array[posInicial]) {
				posicionElemento=posInicial;
				return posicionElemento;
			} else {
				return buscarElemento(array, posInicial+1, elemento);
			}
		}
		return 0;
	}

}
