package co.edu.cue.webapp.drogueria;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.services.ClienteServiceImpl;
import co.edu.cue.webapp.drogueria.services.IClienteService;
import co.edu.cue.webapp.drogueria.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;

public class MainServicesC {

    public static void main(String[] args) throws ClienteException {
        EntityManager em= JpaUtil.getEntityManager();

        IClienteService clienteService= new ClienteServiceImpl(em);
        /*Cliente cliente= setDataCliente();
        listarClientes(clienteService);
        crearCliente(clienteService, cliente);
        listarClientes(clienteService);*/


        /*Cliente cliente1= setDataActualizar(clienteService);
        listarClientes(clienteService);
        actualizarCliente(clienteService, cliente1);*/


        /*int idCliente= setDataEliminar(clienteService);
        eliminarCliente(clienteService, idCliente);
        System.out.println("El cliente fue eliminado");*/

        listarClientes(clienteService);
        em.close();
    }

    private static void listarClientes(IClienteService clienteService) {
        List<Cliente> listaClientes= clienteService.listar();
        imprimirListaClientes(listaClientes);
    }

    private static void crearCliente(IClienteService clienteService, Cliente cliente) {
        clienteService.guardar(cliente);
    }

    private static void actualizarCliente(IClienteService clienteService, Cliente cliente) {
        clienteService.guardar(cliente);
    }

    private static void eliminarCliente(IClienteService clienteService, int id) throws ClienteException {
        clienteService.eliminar(id);
    }

    private static Cliente setDataCliente() {
        Cliente cliente=null;
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
        String cedula= JOptionPane.showInputDialog("Ingrese la cedula: ");
        String direccion= JOptionPane.showInputDialog("Ingrese la direccion: ");
        String telefono= JOptionPane.showInputDialog("Ingrese el telefono: ");
        String correo= JOptionPane.showInputDialog("Ingrese el correo: ");

        cliente= new Cliente();
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        cliente.setCorreo(correo);

        return cliente;
    }


    private static Cliente setDataActualizar(IClienteService clienteService){
        Cliente cliente=null;

        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a actualizar"));

        cliente=clienteService.obtenerPorId(idCliente);

        String campoActualizar=JOptionPane.showInputDialog("Ingrese el nombre del campo a actualizar");

        if (campoActualizar.equalsIgnoreCase("nombre")){
            String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
            cliente.setNombre(nombre);
        } else if (campoActualizar.equalsIgnoreCase("cedula")){
            String cedula= JOptionPane.showInputDialog("Ingrese la cedula: ");
            cliente.setCedula(cedula);
        }else if (campoActualizar.equalsIgnoreCase("direccion")){
            String direccion= JOptionPane.showInputDialog("Ingrese la direccion: ");
            cliente.setDireccion(direccion);
        }else if (campoActualizar.equalsIgnoreCase("telefono")){
            String telefono= JOptionPane.showInputDialog("Ingrese el telefono: ");
            cliente.setTelefono(telefono);
        }else if (campoActualizar.equalsIgnoreCase("correo")){
            String correo= JOptionPane.showInputDialog("Ingrese el correo: ");
            cliente.setCorreo(correo);
        }
        return cliente;
    }


    private static int setDataEliminar(IClienteService clienteService){
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar"));
        return idCliente;
    }


    private static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }

}
