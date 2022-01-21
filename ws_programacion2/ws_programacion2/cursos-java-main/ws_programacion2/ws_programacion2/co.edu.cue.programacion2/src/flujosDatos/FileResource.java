package flujosDatos;
//https://www.discoduroderoer.es/clases-filereader-y-filewriter-para-ficheros-de-texto-en-java/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileResource {

	public static void main(String[] args) {
		
//		fileReaderYWriter_V1();
//		fileReaderYWriter_V2();
//		fileReaderYWriter_V3();
		
//		bufferReaderYWriter_V1();
		bufferReaderYWriter_V2();
		
	}

	private static void fileReaderYWriter_V1() {

		try{
			//Abro stream, crea el fichero si no existe
			FileWriter fw=new FileWriter("C://td//directorioPrueba//fichero1.txt",true);
			
			//Escribimos en el fichero un String y un caracter 97 (a)
			fw.write("Esto es una prueb"+"\n");
			fw.write(97);
			
			//Cierro el stream
			fw.close(); 
			
			//Abro el stream, el fichero debe existir
			FileReader fr=new FileReader("C://td//directorioPrueba//fichero1.txt");
			
			//Leemos el fichero y lo mostramos por pantalla
			int valor=fr.read();
			while(valor!=-1){
				System.out.print((char)valor);
				valor=fr.read();
			}
			//Cerramos el stream
			fr.close();
			
		}catch(IOException e){
			System.out.println("Error E/S: "+e);
		}
	}

	private static void fileReaderYWriter_V2() {

		/**
		Si ejecutamos el código, no escribirá nada en pantalla pero si escribirá en el fichero, 
		la pregunta es ¿Porque? La respuesta es que  cuando se cierra el stream, es como si pincháramos en guardar
		de forma gráfica, es decir, que si no cerramos el stream es como si el fichero estuviera vacio. 
		También debemos tener en cuenta que esto se debe a que leemos y modificamos el mismo fichero en el mismo tiempo.**/

		try{
			//Creo los objetos, abro streams
			FileWriter fw=new FileWriter("C://td//directorioPrueba//fichero2.txt");
			FileReader fr=new FileReader("C://td//directorioPrueba//fichero2.txt");
			//Escribimos en el fichero un String y un caracter 97 (a)
			fw.write("Esto es una prueb");
			fw.write(97);

			//Leemos el fichero y lo mostramos por pantalla
			int valor=fr.read();
			while(valor!=-1){
				System.out.print((char)valor);
				valor=fr.read();
			}
			//Cerramos el stream
			fw.close();
			fr.close();
		}catch(IOException e){
			System.out.println("Error E/S: "+e);
		}
		
	}

	private static void fileReaderYWriter_V3() {

		/**
		Desde java 7 tenemos una mejor forma de abrir y cerrar stream, ahorrándonos trabajo.
		Como vemos, en el try creamos los objetos que queremos manejar, separados con un ; 
		por objeto, con esta forma los streams se cierran automáticamente.
		**/

		try(
				FileWriter fw=new FileWriter("C://td//directorioPrueba//fichero3.txt");
				FileReader fr=new FileReader("C://td//directorioPrueba//fichero3.txt"))
		{
			//Escribimos en el fichero un String y un caracter 97 (a)
			fw.write("Esto es una prueb_");
			fw.write(97);

			//Guardamos los cambios del fichero
			fw.flush();

			//Leemos el fichero y lo mostramos por pantalla
			int valor=fr.read();
			while(valor!=-1){
				System.out.print((char)valor);
				valor=fr.read();
			}
		}catch(IOException e){
			System.out.println("Error E/S: "+e);
		}
	}

	
	
	
	private static void bufferReaderYWriter_V1() 
	{
		
		//El archivo debe de estar creado
		try(BufferedReader br=new BufferedReader(new FileReader("C://td//directorioPrueba//fichero4.txt"));
			BufferedWriter bw=new BufferedWriter(new FileWriter("C://td//directorioPrueba//fichero4.txt"));){
			
			//Escribimos en el fichero
			bw.write("Esto es una prueba usando Buffered");
			bw.newLine();
			bw.write("Seguimos usando Buffered");
			
			//Guardamos los cambios del fichero
			bw.flush();
			
			//Leemos el fichero y lo mostramos por pantalla
			String linea=br.readLine();
			while(linea!=null){
				System.out.println(linea);
				linea=br.readLine();
			}
		}catch(IOException e){
			
			
			
			System.out.println("Error E/S: "+e);
		}

	}

	
	private static void bufferReaderYWriter_V2() 
	{
		
		File ficheroNuevo=new File("C://td//directorioPrueba//fichero5.txt");
		
		
		if(!ficheroNuevo.exists())
		{
			try {
				ficheroNuevo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//El archivo debe de estar creado
		try(BufferedReader br=new BufferedReader(new FileReader(ficheroNuevo));
			BufferedWriter bw=new BufferedWriter(new FileWriter(ficheroNuevo));){
			
			//Escribimos en el fichero
			bw.write("Esto es una prueba usando Buffered");
			bw.newLine();
			bw.write("Seguimos usando Buffered");
			
			//Guardamos los cambios del fichero
			bw.flush();
			
			//Leemos el fichero y lo mostramos por pantalla
			String linea=br.readLine();
			while(linea!=null){
				System.out.println(linea);
				linea=br.readLine();
			}
		}catch(IOException e){
			
			
			
			System.out.println("Error E/S: "+e);
		}

	}
	
	
//	mismo ejemplo pero con métodos
	private static void bufferReaderYWriter_V3() 
	{
		try(BufferedReader br=new BufferedReader(new FileReader("C://td//directorioPrueba//fichero6.txt"));
			BufferedWriter bw=new BufferedWriter(new FileWriter("C://td//directorioPrueba//fichero6.txt"));){
			
			escribeFichero(bw);
			//Guardamos los cambios del fichero
			bw.flush();
			leeFichero(br);
		}catch(IOException e){
			System.out.println("Error E/S: "+e);
		}
	}
	
	
	
	
	public static void escribeFichero(BufferedWriter bw) throws IOException{
		//Escribimos en el fichero
		bw.write("Esto es una prueba usando Buffered");
		bw.newLine();
		bw.write("Seguimos usando Buffered");
	}
	public static void leeFichero(BufferedReader br) throws IOException{
		//Leemos el fichero y lo mostramos por pantalla
		String linea=br.readLine();
		while(linea!=null){
			System.out.println(linea);
			linea=br.readLine();        }
	}
	
	
	
	private static void ejemplo3() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
