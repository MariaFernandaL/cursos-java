package co.edu.cue.recursividad.model;

public class CambioReferencia {

	public void cambiarValor(Persona pruebaObjeto) 
	{
		pruebaObjeto.edad = 10;
		System.out.println("Valor modificado en el metodo"+ pruebaObjeto.edad);
	}
	
}
