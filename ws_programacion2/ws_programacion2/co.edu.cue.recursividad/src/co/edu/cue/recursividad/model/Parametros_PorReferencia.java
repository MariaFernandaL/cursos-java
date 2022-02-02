package co.edu.cue.recursividad.model;

public class Parametros_PorReferencia {

	public static void main(String[] args) 
	{
		//Paso por referencia
		Persona pruebaObjeto = new Persona();
		System.out.println("Valor del objeto antes de modificar: "+pruebaObjeto.edad);
		
		CambioReferencia clase2 = new CambioReferencia();
		clase2.cambiarValor(pruebaObjeto);
		System.out.println("Valor del objeto al cambiarlo: "+pruebaObjeto.edad);
	}
}
