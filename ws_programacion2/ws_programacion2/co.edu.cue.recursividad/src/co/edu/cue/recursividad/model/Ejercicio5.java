package co.edu.cue.recursividad.model;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		int [] array= {1,2,3,4,1,1,6,1};
		int inicio=0;
		int final1=array.length;
		int elemento=1;
		System.out.println("En el arreglo hay: "+elementoRepetido(array, inicio, final1, elemento)+" ---- unos");
		
	}

	public static int elementoRepetido(int array [], int inicio, int final1, int elemento){
		
		int contador=0;
		if (inicio<final1) {
			if (elemento==array[inicio]) {
				contador=1+elementoRepetido(array, inicio+1, final1, elemento);
				return contador;
			} else {
				contador= 0+elementoRepetido(array, inicio+1, final1, elemento);
				return contador;
			}
		}
		return 0;
	}
}
