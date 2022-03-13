package co.edu.cue.tallerApropiacion.model;

import javax.swing.JOptionPane;

public class Agenda {

private Contacto [] misContactos;
private int NumContactos;



public Agenda() {
	this.misContactos=new Contacto[10];
	
}

public Agenda(int tama) {
	
	this.misContactos=new Contacto[tama];
}


	
	public void agregarContacto(Contacto c) {
		
		if (existeContacto(c)) {
			JOptionPane.showMessageDialog(null, "El nombre de este contacto ya existe");
		}else if (agendaLlena()) {
			JOptionPane.showMessageDialog(null, "La agenda esta llena, no se permiten mas contactos");
		}else {
			boolean encontrado=false;
			for (int i = 0; i < misContactos.length && !encontrado; i++) {
				if (misContactos[i]==null) {
					misContactos[i]=c;
					encontrado=true;
				}
			}
			
			if (encontrado) {
				JOptionPane.showMessageDialog(null, "Se ha añadido un nuevo contacto");
			}else {
				JOptionPane.showMessageDialog(null, "No se ha podido añadir el contacto");
			}
		}
		
	}
	
	
	
	
	
	public boolean existeContacto(Contacto c) {
		
		for (int i = 0; i < misContactos.length; i++) {
			if (misContactos[i].getNombre().equalsIgnoreCase(null)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void listarContacto() {
		
		for (int i = 0; i < misContactos.length; i++) {
			
			if (misContactos[i]!=null ) {
				JOptionPane.showMessageDialog(null, misContactos[i]);
			}
		}
		
		
	}
	

	public void buscaContactoNombre(String nombre) {
		boolean encontrado=false;
		
		for (int i = 0; i < misContactos.length && !encontrado; i++) {
			if (misContactos[i]!= null && misContactos[i].getNombre().equalsIgnoreCase(nombre)) {
				JOptionPane.showMessageDialog(null, "Su telefono es: "+misContactos[i].getTelefono());
				encontrado=true;
			}
		}
		
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No se encontro el contacto");
		}
	}
	
	
	
	public void buscaContactoTelefono(String telefono) {
		
		boolean encontrado=false;
		
		for (int i = 0; i < misContactos.length && !encontrado; i++) {
			
			if (misContactos[i]!= null && misContactos[i].getNombre().equalsIgnoreCase(telefono)) {
				JOptionPane.showMessageDialog(null, "Su nombre es: "+misContactos[i].getNombre());
				encontrado=true;
			
			}
		}
		
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "No se encontro el contacto");
		}
	}
	
	
	
	
	public void eliminarContacto(Contacto c) {
		
		boolean encontrado=false;
		for (int i = 0; i < misContactos.length && !encontrado; i++) {
			if (misContactos[i]!=null && misContactos[i].equals(c)) {
			misContactos[i]=null;	
			encontrado=true;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "El contacto no fue eliminado");
		}
	}
	
	
	
	
	public boolean agendaLlena() {
		
		for (int i = 0; i < misContactos.length; i++) {
			if (misContactos[i]==null) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	public int espaciosDisponibles() {
		
		int contador=0;
		for (int i = 0; i < misContactos.length; i++) {
			if (misContactos[i]==null) {
				contador++;
			}
		}
		return contador;
	}


	//Metodos accesores
	public Contacto[] getMisContactos() {
		return misContactos;
	}


	public void setMisContactos(Contacto[] misContactos) {
		this.misContactos = misContactos;
	}

	public int getNumContactos() {
		return NumContactos;
	}

	public void setNumContactos(int numContactos) {
		NumContactos = numContactos;
	}
	

}
