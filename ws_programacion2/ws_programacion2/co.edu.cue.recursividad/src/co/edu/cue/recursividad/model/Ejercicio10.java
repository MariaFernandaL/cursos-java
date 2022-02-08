package co.edu.cue.recursividad.model;

public class Ejercicio10 {

	public static void main(String[] args) {
	
		String palabra= "hello";

		System.out.println(invertirPalabra(palabra, palabra.length()-1));
        
        
    }
     
     public static String invertirPalabra(String palabra, int longitud){
         
        if(longitud==0){
            return palabra.charAt(longitud)+"";
        }else{
            return palabra.charAt(longitud) + (invertirPalabra(palabra, longitud-1));
        }
         
    }

}
