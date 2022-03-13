package co.edu.cue.preParcial1.persistencia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.cue.preParcial1.Ejercicio1.Estudiante;
import co.edu.cue.preParcial1.Ejercicio2.Facultad;
import co.edu.cue.preParcial1.Ejercicio2.Programa;
import co.edu.cue.preParcial1.Ejercicio2.Universidad;


public class Persistencia {
	
	public static final String RUTA_ARCHIVO_ESTUDIANTES = "../co.edu.cue.preParcial1/src/co/edu/cue/preParcial1/resources/archivoEstudiante.txt";
	public static final String RUTA_ARCHIVO_MODELO_PROGRAMA_XML = "../co.edu.cue.preParcial1/src/co/edu/cue/preParcial1/resources/model.xml";
	public static final String RUTA_ARCHIVO_PROGRAMAMODALIDAD = "../co.edu.cue.preParcial1/src/co/edu/cue/preParcial1/resources/archivoProgramasModalidad.txt";
	
	
//GUARDAR ARCHIVO TXT EJERCICIO 1	
	public static void guardarEstudiantes(ArrayList<Estudiante> listaEstudiantes) throws IOException {
		String contenido = "";
		
		for(Estudiante estudiante:listaEstudiantes) 
		{
			contenido+= estudiante.getCodigo()+","+estudiante.getNombre()+","+estudiante.getNota1()+","+estudiante.getNota2()
		     +","+estudiante.getNota3()+"\n";
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
		
	}

	//GUARDAR ARCHIVO SERIALIZADO XML EJERCICIO 2
public static Universidad cargarRecursoUniversidadXML() {
		
		Universidad universidad = null;
		
		try {
			universidad = (Universidad)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMA_XML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return universidad;

	}
	public static void guardarRecursoUniversidadXML(Universidad universidad) {
		
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_PROGRAMA_XML, universidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//CARGAR DE ARCHIVO TXT EJERCICIO 2 
	public static ArrayList<String> cargarModalidadades() throws FileNotFoundException, IOException {

		ArrayList<String> modalidades =new ArrayList<String>();
		
		ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_PROGRAMAMODALIDAD);
		String linea="";
		String modalidad="";
		
		for (int i = 0; i < contenido.size(); i++)
		{
			linea = contenido.get(i);
			modalidad= "";
			modalidad=linea.split(",")[0];
			modalidades.add(modalidad);
			modalidad= linea.split(",")[1];
			modalidades.add(modalidad);
		}
		return modalidades;
	}

}
