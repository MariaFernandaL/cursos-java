package co.edu.cue.recursividad.model;

public class Parametros_PorValor {

	public static void main(String[] args) 
	{
		//Paso por valor
		int valor = 5;
		
		System.out.println("Valor antes de cambiarlo: "+valor);
		
		CambiarValor clase = new CambiarValor();
		clase.cambiarValor(valor);
		
		System.out.println("Valor despues de cambiarlo: "+valor);

	}
}
