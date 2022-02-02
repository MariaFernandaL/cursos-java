package co.edu.cue.recursividad.model;

public class Ejercicio2 {

	public static void main(String[] args) {
		int [] array= {1,2,0,3,0,0,0,0};
		int elementoBuscar=0;
		int n2=0;
		System.out.println("La cantidad de 0 en el arreglo son: "+contar(array, elementoBuscar, n2));
	}
	
	public static int contar(int [] array,int valor,int posInici) {
        int contador=0;
		if(posInici<array.length){
			if(valor==array[posInici]){
				contador=1+contar(array,valor,posInici+1);
				return contador;
				} else {
					contador=0+ contar(array,valor, posInici+1);
					return contador;
					}
			} 
		return 0;
		} 	
	
	
	
}
