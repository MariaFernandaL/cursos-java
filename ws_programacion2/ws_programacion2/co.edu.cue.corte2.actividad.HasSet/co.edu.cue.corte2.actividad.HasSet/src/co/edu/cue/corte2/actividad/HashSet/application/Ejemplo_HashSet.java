package co.edu.cue.corte2.actividad.HashSet.application;

import java.util.HashSet;
import java.util.Set;

import co.edu.cue.corte2.actividad.HashSet.model.GeneroMusica;

public class Ejemplo_HashSet {
	public static void main(String[] args) {
		ejemplo_HashSet();
	}
	private static void ejemplo_HashSet() {
		Set<GeneroMusica> listaGeneros= new HashSet<GeneroMusica>();
		
		GeneroMusica genero1= new GeneroMusica();
		genero1.setGenero("Salsa");
		genero1.setCodigo("1234");
		
		GeneroMusica genero2= new GeneroMusica();
		genero2.setGenero("Bachata");
		genero2.setCodigo("4321");
		
		GeneroMusica genero3= new GeneroMusica();
		genero3.setGenero("Pop");
		genero3.setCodigo("1234");
		
		listaGeneros.add(genero1);
		listaGeneros.add(genero2);
		listaGeneros.add(genero3);
		
		for (GeneroMusica generoMusica : listaGeneros) {
			System.out.println("Generos de Musica: "+ generoMusica.getGenero());
		}
		System.out.println("Resultado: "+ genero1.hashCode());
		System.out.println("Resultado: "+ genero2.hashCode());
		System.out.println("Resultado: "+ genero3.hashCode());
	}
}
