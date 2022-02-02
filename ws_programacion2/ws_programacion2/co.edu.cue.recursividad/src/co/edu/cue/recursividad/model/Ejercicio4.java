package co.edu.cue.recursividad.model;

public class Ejercicio4 {

	public static void main(String[] args) {
		int n3=67543;
		System.out.println("La suma de las cifras de "+n3+ " es: "+sumarCifrasNum(n3));
	}
		public static int sumarCifrasNum(int numero){
			int residuo;
			if (numero<10) {
				return numero;
			} else {
				residuo= numero%10;
				numero=numero/10;
				return sumarCifrasNum(numero)+residuo;
			}	
		}
}
