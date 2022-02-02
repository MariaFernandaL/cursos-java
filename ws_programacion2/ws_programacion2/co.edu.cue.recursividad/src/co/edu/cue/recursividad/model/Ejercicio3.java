package co.edu.cue.recursividad.model;

public class Ejercicio3 {

	public static void main(String[] args) {
		int [] array= {4,7,3,8,2,9};
		int inicio=0;
		int final1= array.length-1;
		System.out.println("El numero menor del arreglo es: "+numeroMenorArreglo(array, inicio, final1));
	}
	
	public static int numeroMenorArreglo(int [] array, int inicio, int final1){
		int menor;
		int temp;
		if (inicio==final1) {
			return menor = array[inicio];
		} else {
			menor= numeroMenorArreglo(array, inicio+1, final1);
			if (array[inicio]<menor) {
				temp= array[inicio];
			}
			else {
				temp= menor;
			}
		}
		return temp;
	}

}
