package co.edu.cue.lab.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import co.edu.cue.lab.exception.PasswordException;
import co.edu.cue.lab.exception.UserException;

public class Laboratorio {
	private String nombreLaboratorio;


	ArrayList<Estudiante> estudiantes= new ArrayList<>();
	ArrayList<Monitor> monitores= new ArrayList<>();
	ArrayList<Elemento> elementos= new ArrayList<>();
	ArrayList<Prestamo> prestamos= new ArrayList<>();
	
	
	public Laboratorio(String nombre) {
		nombreLaboratorio=nombre;
		inicializarDatos();
		inicializarDatosM();
		inicializarDatosEl();
		inicializarDatosP();
		inicializarDatosElementosP();
	}
	
	public String getNombreLaboratorio() {
		return nombreLaboratorio;
	}

	public void setNombreLaboratorio(String nombreLaboratorio) {
		this.nombreLaboratorio = nombreLaboratorio;
	}

	
	//USUARIOS MONITORES
	public Monitor validarUsuario(String user, String password) throws UserException {
			
		for (Monitor monitor : monitores) {
			if (monitor.getUser().equals(user)) {
				if (monitor.getPassword().equals(password)) {
					return monitor;
				} else {
					throw new UserException("La contraseña es incorrecta");
				} 
			}else {
				throw new UserException("El usuario no existe");
			}
		}
		
		return null;
	
	}
	
	
	//ESTUDIANTES
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	private void inicializarDatos() {

		Estudiante estudiante = new Estudiante();
		estudiante.setNombre("Juan");
		estudiante.setApellido("Arias");
		estudiante.setDocumento("1094");
		estudiante.setDireccion("Armenia");
		this.getEstudiantes().add(estudiante);

		estudiante = new Estudiante();
		estudiante.setNombre("Pedro");
		estudiante.setApellido("Perez");
		estudiante.setDocumento("1095");
		estudiante.setDireccion("Quimbaya");
		this.getEstudiantes().add(estudiante);

		estudiante = new Estudiante();
		estudiante.setNombre("Jose");
		estudiante.setApellido("Restrepo");
		estudiante.setDocumento("1096");
		estudiante.setDireccion("Salento");
		this.getEstudiantes().add(estudiante);
	}
	
	public Estudiante crearEstudiante(String nombre, String apellido, String documento, String direccion) {

		Estudiante nuevoEstudiante = new Estudiante();
		nuevoEstudiante.setNombre(nombre);
		nuevoEstudiante.setApellido(apellido);
		nuevoEstudiante.setDocumento(documento);
		nuevoEstudiante.setDireccion(direccion);
		getEstudiantes().add(nuevoEstudiante);

		return nuevoEstudiante;
	}

	public boolean eliminarEstudiante(String documento) {

		Estudiante estudiante = null;

		estudiante = obtenerEstudiante(documento);

		if(estudiante != null){
			getEstudiantes().remove(estudiante);
			return true;
		}else{
			return false;
		}

	}

	public Estudiante obtenerEstudiante(String documento) {

		for (Estudiante estudiante : estudiantes) {

			if(estudiante.getDocumento().equals(documento))
			{
				return estudiante;
			}
		}
		return null;

	}

	public boolean actualizarEstudiante(String documentoActual, String nombre, String apellido, String documento, String direccion) {

		Estudiante estudiante = null;

		estudiante = obtenerEstudiante(documentoActual);

		if(estudiante != null){

			estudiante.setNombre(nombre);
			estudiante.setApellido(apellido);
			estudiante.setDocumento(documento);
			estudiante.setDireccion(direccion);

			return true;
		}else{
			return false;
		}


	}

	
	//MONITOR
	public ArrayList<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(ArrayList<Monitor> monitores) {
		this.monitores = monitores;
	}
	
	private void inicializarDatosM() {


		Monitor monitor = new Monitor();
		monitor.setNombre("Sofio");
		monitor.setApellido("Lopez");
		monitor.setDocumento("9754");
		monitor.setDireccion("Armenia");
		monitor.setSalario("345.000");
		monitor.setUser("slopez123");
		monitor.setPassword("123456");
		this.getMonitores().add(monitor);

		
		monitor = new Monitor();
		monitor.setNombre("Paola");
		monitor.setApellido("Jimenez");
		monitor.setDocumento("9510");
		monitor.setDireccion("Quimbaya");
		monitor.setSalario("400.000");
		monitor.setUser("pjimenez456");
		monitor.setPassword("654321");
		this.getMonitores().add(monitor);

		monitor = new Monitor();
		monitor.setNombre("Alejandro");
		monitor.setApellido("Rodriguez");
		monitor.setDocumento("9610");
		monitor.setDireccion("Salento");
		monitor.setSalario("290.000");
		monitor.setUser("arodriguez321");
		monitor.setPassword("78910");
		this.getMonitores().add(monitor);
	}
	
	
	public Monitor crearMonitor(String nombre, String apellido, String documento, String direccion, String salario, String user, String password) {

		Monitor nuevoMonitor = new Monitor();
		nuevoMonitor.setNombre(nombre);
		nuevoMonitor.setApellido(apellido);
		nuevoMonitor.setDocumento(documento);
		nuevoMonitor.setDireccion(direccion);
		nuevoMonitor.setSalario(salario);
		nuevoMonitor.setUser(user);
		nuevoMonitor.setPassword(password);
		getMonitores().add(nuevoMonitor);

		return nuevoMonitor;
	}
	
	public boolean eliminarMonitor(String documento) {

		Monitor monitor = null;

		monitor = obtenerMonitor(documento);

		if(monitor != null){
			getMonitores().remove(monitor);
			return true;
		}else{
			return false;
		}

	}
	
	
	private Monitor obtenerMonitor(String documento) {

		for (Monitor monitor : monitores) {

			if(monitor.getDocumento().equals(documento))
			{
				return monitor;
			}
		}
		return null;

	}

	
	public boolean actualizarMonitor(String documentoActual, String nombre, String apellido, String documento, String direccion, String salario, String user, String password) {

		Monitor monitor = null;

		monitor = obtenerMonitor(documentoActual);

		if(monitor != null){

			monitor.setNombre(nombre);
			monitor.setApellido(apellido);
			monitor.setDocumento(documento);
			monitor.setDireccion(direccion);
			monitor.setSalario(salario);
			monitor.setUser(user);
			monitor.setPassword(password);

			return true;
		}else{
			return false;
		}
	}
	
	//ELEMENTOS
	
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}

	
	public void setElementos(ArrayList<Elemento> listelementos) {
		this.elementos = listelementos;
	}
	
	private void inicializarDatosEl() {


		Elemento elemento = new Elemento();
		elemento.setNombreElemento("ComputadorPortatil");
		elemento.setCodigo("2435");
		elemento.setCantElemento(7);
		this.getElementos().add(elemento);

		elemento = new Elemento();
		elemento.setNombreElemento("Extension");
		elemento.setCodigo("7584");
		elemento.setCantElemento(2);
		this.getElementos().add(elemento);
		
		elemento = new Elemento();
		elemento.setNombreElemento("FichasLego");
		elemento.setCodigo("1927");
		elemento.setCantElemento(40);
		this.getElementos().add(elemento);
		
		elemento = new Elemento();
		elemento.setNombreElemento("Maquina");
		elemento.setCodigo("4567");
		elemento.setCantElemento(10);
		this.getElementos().add(elemento);
	}
	
	public Elemento crearElemento(String nombreE, String codigo, int cantDisponible) {
		
		Elemento nuevoElemento = new Elemento();
		nuevoElemento.setNombreElemento(nombreE);
		nuevoElemento.setCodigo(codigo);
		nuevoElemento.setCantElemento(cantDisponible);
		getElementos().add(nuevoElemento);

		return nuevoElemento;
	}

	
	public boolean eliminarElemento(String codigo) {
		Elemento elemento= null;
		elemento= obtenerElemento(codigo);
		if (elemento!=null) {
			getElementos().remove(elemento);
			return true;
		} else {
			return false;
		}
	}
	

	public Elemento obtenerElemento(String codigo) {

		for (Elemento elemento : elementos) {

			if(elemento.getCodigo().equals(codigo))
			{
				return elemento;
			}
		}
		return null;

	}

	public boolean actualizarElemento(String codigoActual, String nombreE, String codigo, int cantDisponible) {

		Elemento elemento = null;

		elemento = obtenerElemento(codigoActual);

		if(elemento != null){

			elemento.setNombreElemento(nombreE);
			elemento.setCodigo(codigo);
			elemento.setCantElemento(cantDisponible);

			return true;
		}else{
			return false;
		}


	}
	
	
	//PRESTAMO
	
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> listPrestamos) {
		this.prestamos = listPrestamos;
	}
	
	public ArrayList<DetallePrestamo> getDetallePrestamos() {
		return elementosPrestamo;
	}

	public void setDetallePrestamos(ArrayList<DetallePrestamo> listDetallePres) {
		this.elementosPrestamo = listDetallePres;
	}
	
	
	private void inicializarDatosP() {
		
		LocalDate fechaP= LocalDate.of(2021, 12, 23);
		LocalDate fechaE= LocalDate.of(2021, 12, 28);
		DetallePrestamo detalle= new DetallePrestamo();
		detalle.setElemento(new Elemento("computador", "1234", 3,6));
		DetallePrestamo detalle2= new DetallePrestamo();
		detalle2.setElemento(new Elemento("fisher", "1234", 3, 7));
		
		ArrayList<DetallePrestamo> elementosPrestados= new ArrayList<>();
		elementosPrestados.add(detalle2);
		elementosPrestados.add(detalle);
		
		Prestamo prestamo= new Prestamo();
		prestamo.setEstudiante(estudiantes.get(0));
		prestamo.setMonitor(monitores.get(0));
		prestamo.setElementos(elementosPrestados);
		prestamo.setFechaPrestamo(fechaP);
		prestamo.setFechaEntrega(fechaE);
		prestamo.setCodigoPrestamo("12345");
		this.getPrestamos().add(prestamo);

		LocalDate fechaP1= LocalDate.of(2021, 11, 15);
		LocalDate fechaE1= LocalDate.of(2021, 11, 20);
		DetallePrestamo detalleP1= new DetallePrestamo();
		detalleP1.setElemento(elementos.get(0));
		DetallePrestamo detalleP2= new DetallePrestamo();
		detalleP2.setElemento(elementos.get(1));
		
		elementosPrestados= new ArrayList<>();
		elementosPrestados.add(detalleP1);
		elementosPrestados.add(detalleP2);
		
		prestamo= new Prestamo();
		prestamo.setEstudiante(estudiantes.get(1));
		prestamo.setMonitor(monitores.get(1));
		prestamo.setElementos(elementosPrestados);
		prestamo.setFechaPrestamo(fechaP1);
		prestamo.setFechaEntrega(fechaE1);
		prestamo.setCodigoPrestamo("54321");

		this.getPrestamos().add(prestamo);

	}
	
	private void inicializarDatosElementosP() {

		DetallePrestamo elementoPrestamo= new DetallePrestamo();
		elementoPrestamo.setElemento(elementos.get(0));
		elementoPrestamo.setCantidad(3);
		this.getElementosPrestamo().add(elementoPrestamo);
		
		elementoPrestamo= new DetallePrestamo();
		elementoPrestamo.setElemento(elementos.get(1));
		elementoPrestamo.setCantidad(2);
		this.getElementosPrestamo().add(elementoPrestamo);
		
		elementoPrestamo= new DetallePrestamo();
		elementoPrestamo.setElemento(elementos.get(2));
		elementoPrestamo.setCantidad(20);
		this.getElementosPrestamo().add(elementoPrestamo);
		
		elementoPrestamo= new DetallePrestamo();
		elementoPrestamo.setElemento(elementos.get(3));
		elementoPrestamo.setCantidad(2);
		this.getElementosPrestamo().add(elementoPrestamo);
	}
	
	
	ArrayList<DetallePrestamo> elementosPrestamo= new ArrayList<>();
	
	public ArrayList<DetallePrestamo> getElementosPrestamo() {
		return elementosPrestamo;
	}
	
	public void crearElementoPrestamo(Elemento elemento, int cantidad) {
		
		DetallePrestamo nuevoElementoP= new DetallePrestamo();
		nuevoElementoP.setElemento(elemento);
		nuevoElementoP.setCantidad(cantidad);
		getElementosPrestamo().add(nuevoElementoP);
		
	}
		
	public boolean validarEstadoElemento(String codigoElemento, int cantidad) {
		Elemento elemento= obtenerElemento(codigoElemento);
		
		if (elemento!=null) {
				if (elemento.getCantElemento()>=cantidad) {
					elemento.setEstado(true);
					JOptionPane.showMessageDialog(null, "El elemento si esta disponible");
					return true;
			} else if (elemento.getCantElemento()<cantidad) {
				JOptionPane.showMessageDialog(null, "El elemento no esta disponible");
			}
		}
		
		return false;
	}

	public Prestamo crearPrestamo(Estudiante estudiante, Monitor monitor,ArrayList<DetallePrestamo> listaElementos,LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo) {
		
		
		if (listaElementos!=null) {
			
			for (DetallePrestamo detallePrestamo : listaElementos) {
				for (Elemento elemento: elementos) {
					if (detallePrestamo.getElemento()==elemento) {
						int nuevoValor= elemento.getCantElemento()-detallePrestamo.getCantidad();
						elemento.setCantElemento(nuevoValor);
						JOptionPane.showMessageDialog(null, "La cantidad del elemento fue cambiada");
					}
					
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "La cantidad del elemento no fue cambiada");
		}
		
		Prestamo nuevoPrestamo = new Prestamo();
		nuevoPrestamo.setEstudiante(estudiante);
		nuevoPrestamo.setMonitor(monitor);
		nuevoPrestamo.setElementos(listaElementos);
		nuevoPrestamo.setFechaPrestamo(fechaPrestamo);
		nuevoPrestamo.setCodigoPrestamo(codigo);
		getPrestamos().add(nuevoPrestamo);

		return nuevoPrestamo;
	}
	
	
	public Prestamo obtenerPrestamo(String codigoPrestamo) {
		
		for (Prestamo prestamo: prestamos) {

			if(prestamo.getCodigoPrestamo().equals(codigoPrestamo))
			{
				return prestamo;
			}
		}
		return null;
	}
	
public DetallePrestamo obtenerElementoPrestamo(String codigoElemento) {
		
		for (DetallePrestamo dp: elementosPrestamo) {

			if(dp.getElemento().getCodigo().equals(codigoElemento))
			{
				return dp;
			}
		}
		return null;
	}
	
	public boolean eliminarElementoPrestamo(String codigo) {

		DetallePrestamo dp= null;

		dp= obtenerElementoPrestamo(codigo);

		if(dp != null){
			getDetallePrestamos().remove(dp);
			return true;
		}else{
			return false;
		}

	}
	
	public boolean devolverPrestamo(String codigoPrestamo) {
		Prestamo prestamo= obtenerPrestamo(codigoPrestamo);
		if (prestamo!=null) {
			if (elementosPrestamo!=null) {
				if (elementos!=null) {
					for (DetallePrestamo detallePrestamo : elementosPrestamo) {
						for (Elemento elemento: elementos) {
							int nuevoValor= elemento.getCantElemento()+detallePrestamo.getCantidad();
							elemento.setCantElemento(nuevoValor);
							elemento.setEstado(true);
							JOptionPane.showMessageDialog(null, "La cantidad del elemento fue cambiada");
							return true;
						}
						}
				}
			}
		}
	return false;
	}
	
}