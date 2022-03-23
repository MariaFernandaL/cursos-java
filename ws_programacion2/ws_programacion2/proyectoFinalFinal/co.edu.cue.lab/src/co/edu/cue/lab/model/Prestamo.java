package co.edu.cue.lab.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prestamo {

	
	private Estudiante estudiante;
	private Monitor monitor;
	private ArrayList<DetallePrestamo> elementos=new ArrayList<>();
	private LocalDate fechaPrestamo= LocalDate.now();
	private LocalDate fechaEntrega= LocalDate.now();
	private String codigoPrestamo;
	
	/********/
	private String nombreEstudiante;
	
	public String getNombreEstudiante() {
		return this.estudiante.getNombre();
	}
	/*********/
	
	public Prestamo() {
		
	}
	
	public Prestamo(Estudiante estudiante, Monitor monitor,ArrayList<DetallePrestamo> elementos,
			LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo) {
		super();
		this.estudiante = estudiante;
		this.monitor = monitor;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaEntrega = fechaEntrega;
		this.codigoPrestamo= codigo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	
	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public ArrayList<DetallePrestamo> getElementos() {
		return elementos;
	}

	public void setElementos(ArrayList<DetallePrestamo> elementos) {
		this.elementos = elementos;
	}
	public String getCodigoPrestamo() {
		return codigoPrestamo;
	}
	public void setCodigoPrestamo(String codigoPrestamo) {
		this.codigoPrestamo = codigoPrestamo;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	
}
