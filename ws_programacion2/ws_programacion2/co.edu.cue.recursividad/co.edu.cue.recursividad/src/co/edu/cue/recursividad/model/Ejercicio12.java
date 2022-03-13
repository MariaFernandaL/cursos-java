package co.edu.cue.recursividad.model;

public class Ejercicio12 {

	public static void main(String[] args) {

		int base = 2;
		int potencia = 5;
		
		System.out.println(calcularPotencia(base,potencia));
	}
	
	private static int calcularPotencia(int base, int potencia) {
		
		if(potencia == 1)
		{
			return base;
		}
		else
		{
			return calcularPotencia(base, potencia-1)*base;
		}
	}
}
