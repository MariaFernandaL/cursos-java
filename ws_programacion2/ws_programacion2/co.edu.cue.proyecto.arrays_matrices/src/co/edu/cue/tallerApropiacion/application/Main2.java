package co.edu.cue.tallerApropiacion.application;

import javax.swing.JOptionPane;

import co.edu.cue.tallerApropiacion.model.Agenda;
import co.edu.cue.tallerApropiacion.model.Contacto;

public class Main2 {

	public static void main(String[] args) {
		
		
		boolean salir=false;
		int opcion;
		
		int cantContac=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de contactos que desea tener en su agenda"));
		Agenda agendaContactos=new Agenda(cantContac);		
		
		String nombre;
		String telefono;
		Contacto c;
		
		
		while (!salir) {
			System.out.println("1. Agregar Contacto");
			System.out.println("2. Listar Contacto");
			System.out.println("3. Buscar Contacto por el nombre");
			System.out.println("4. Existe Contacto");
			System.out.println("5. Eliminar contacto");
			System.out.println("6. Espacios disponibles");
			System.out.println("7. Agenda Llena");	
			System.out.println("8. Salir");
		try {
			opcion=Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de la opcion que desea llevar a cabo del menú"));
			
			switch (opcion) {
			case 1:
				nombre= JOptionPane.showInputDialog("Ingrese el nombre del contacto");
				telefono=JOptionPane.showInputDialog("Ingrese el telefono del contacto");
		
				c=	new Contacto(nombre,telefono);			
				agendaContactos.agregarContacto(c);
				break;
				
			case 2:
				agendaContactos.listarContacto();
				break;
			case 3:
				nombre= JOptionPane.showInputDialog("Ingrese el nombre del contacto");
				agendaContactos.buscaContactoNombre(nombre);
				break;
				
			case 4:
				nombre= JOptionPane.showInputDialog("Ingrese el nombre del contacto");
				telefono=JOptionPane.showInputDialog("Ingrese el telefono del contacto");
				c=new Contacto(nombre,telefono);
				
				
				if (agendaContactos.existeContacto(c)) {
					JOptionPane.showMessageDialog(null, "El contacto ya existe");
				}else {
					JOptionPane.showMessageDialog(null, "El contacto no existe aun");
				}
				break;
				
				
			case 5:
				nombre= JOptionPane.showInputDialog("Ingrese el nombre del contacto");
				telefono=JOptionPane.showInputDialog("Ingrese el telefono del contacto");
				c=new Contacto(nombre,telefono);
				
				agendaContactos.eliminarContacto(c);
				
				break;
			
			case 6:
				JOptionPane.showMessageDialog(null, "Hay "+agendaContactos.espaciosDisponibles()+" espacios de contactos libres");
				break;
				
			case 7:
				
				if (agendaContactos.agendaLlena()) {
					JOptionPane.showMessageDialog(null, "La agenda esta llena");
				}else {
					JOptionPane.showMessageDialog(null, "Puedes agregar mas contactos");
				}
				break;
				
			case 8:
				salir=true;
				break;
		
			default:
				JOptionPane.showMessageDialog(null, "El numero dado no pertenece a ninguna opcion del menu");
				break;
			}

		}finally {
			
		}
}
	}
}
