package flujosDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

public class EjemplosBasicos {
	
	
	private static final Logger LOGGER = Logger.getLogger(EjemplosBasicos.class.getName());

	public static void main(String[] args) {
		
		

		//Archivos de Registro
//		archivoRegistro();
		
		
		//Manejo de carpetas (directorios)
		manejoCarpetas();

	}

	
	private static void archivoRegistro() {
		//Log   --> historial eventos del sistema
		
		FileHandler archivo;
		
		try {
			archivo = new FileHandler("src/resources/MyLog.txt",true);
			archivo.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(archivo);
			
			
			LOGGER.log(Level.INFO, "Primer mensaje 1.1");
			LOGGER.log(Level.WARNING, "Segundo mensaje 2.1");
			LOGGER.log(Level.SEVERE, "Tercer mensaje 3.1");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void manejoCarpetas() {
		
		String salida, ruta;
		File directorio;
		
		ruta = "C:/td/directorioPrueba";
		
		directorio = new File(ruta);
		
		salida = "Los directorios (carpetas) no ocultas de"+ ruta+ " son: \n";
		
		for (File elemento : directorio.listFiles())
		{
			if(elemento.isDirectory()  && !elemento.isHidden())
			{
				salida+= elemento.getName()+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, salida);
		
	}
	

	

	

}
