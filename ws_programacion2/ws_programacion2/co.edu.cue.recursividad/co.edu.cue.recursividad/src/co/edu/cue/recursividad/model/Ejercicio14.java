package co.edu.cue.recursividad.model;

public class Ejercicio14 {

	public static void main(String[] args) {
		
		 int[] array={1,2,3,4,5};
	        int elementoBuscar=5;
	        int posElementoEncontrado=posicionElementoRecursivo(array, elementoBuscar,0);
	        System.out.println("El elemento a buscar = "+elementoBuscar+ " esta en la posición "+posElementoEncontrado);
	         
	    }
	     
	    public static int posicionElementoRecursivo(int[] array, int elementoBuscar ,int indice){
	         
	       if(indice==array.length || array[indice]==elementoBuscar){
	             
	            if(indice==array.length){
	               return -1; 
	            }else{
	                return indice;
	            }
	             
	        }else{
	            return posicionElementoRecursivo(array, elementoBuscar, indice+1);
	        }
	         
	    }
	

}
