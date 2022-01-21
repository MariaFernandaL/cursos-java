package flujosDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Formatter;

public class Persistencia {

	public static void almacenarDatos(String rutaArchivo, String formato, Object args,Object args1,Object args2,Object args3) throws IOException {
		
		FileWriter archivoSalidad;
		Formatter archivo;
		
		archivo = new Formatter(rutaArchivo);
		archivo.format(formato, args,args1,args2,args3);
		archivo.flush();
		archivo.close();
		
//		archivoSalidad = new FileWriter(rutaArchivo, true);
//		archivo = new Formatter(archivoSalidad);
//		archivo.format(formato, args,args1,args2,args3);
//		archivo.flush();
//		archivo.close();

	}
	
	
	public static void escribirArchivo(String rutaArchivo, ArrayList<String> texto,boolean adicionar) throws IOException 
	{
		
		FileWriter archivoSalida = null;
		BufferedWriter  bufferSalida;
		
		archivoSalida = new FileWriter(rutaArchivo, adicionar);
		bufferSalida =  new BufferedWriter(archivoSalida);
		
		for (String linea : texto) 
		{
			bufferSalida.write(linea+"\n");
		}
		
		
		bufferSalida.flush();
		bufferSalida.close();
		
		archivoSalida.close();
	}
	
	
	public static ArrayList<String> leerArchivo(String ruta) throws IOException {

		ArrayList<String>  contenido = new ArrayList<String>();
		FileReader fr=new FileReader(ruta);
		BufferedReader bfr=new BufferedReader(fr);
		String linea="";
		while((linea = bfr.readLine())!=null) 
		{
			contenido.add(linea);
		}
		bfr.close();
		fr.close();
		return contenido;
	}
	
	
	public static void serializarObjeto (String rutaArchivo, Object objeto) throws IOException 
	{
		ObjectOutputStream salidaObjeto;
		
		
		salidaObjeto = new ObjectOutputStream(new FileOutputStream(rutaArchivo)); 
		salidaObjeto.writeObject(objeto);
		salidaObjeto.close();
	}
	
	
	public static Object deseRializarObjeto (String nombreArchivo) throws Exception 
	{
		Object objecto;
		ObjectInputStream entradaObjeto;
		
		entradaObjeto = new ObjectInputStream(new FileInputStream(nombreArchivo));
		objecto = entradaObjeto.readObject();
		entradaObjeto.close();
		
		return objecto;
	}
	
	
	
}
