package co.edu.cue.webapp.drogueria;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //obtenerClientes();
        //obtenerClientePorId();
        //obtenerClientePorIdWhere();

        //CRUD
        //crearCliente();
        //eliminarCliente();
       //actualizarCliente();
    }

    private static void obtenerClientes() {
        EntityManager em= JpaUtil.getEntityManager();
        List<Cliente> listaClientes= null;
        listaClientes= em.createQuery("select c from Cliente c", Cliente.class).getResultList();

        imprimirListaClientes(listaClientes);
        em.close();
    }

    private static void obtenerClientePorId() {
        EntityManager em= JpaUtil.getEntityManager();
        Cliente cliente=null;

        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese el ID");
        int id= s.nextInt();

        cliente= em.find(Cliente.class,id);

        if (cliente!=null){
            System.out.println(cliente.toString());
        } else {
            System.out.println("El cliente no existe");
        }
        em.close();
    }

    private static void obtenerClientePorIdWhere() {
        EntityManager em= JpaUtil.getEntityManager();
        Cliente cliente=null;

        Scanner s= new Scanner(System.in);
        System.out.println("Ingrese el ID");
        int id= s.nextInt();


       Query query = em.createQuery("select c from Cliente c where c.idCliente=" + id, Cliente.class);

        List<Cliente> listaClientes = query.getResultList();

        imprimirListaClientes(listaClientes);
        em.close();
    }

    public static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }

    private static void crearCliente(){
        EntityManager em= JpaUtil.getEntityManager();

        try {
            String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
            String cedula= JOptionPane.showInputDialog("Ingrese la cedula: ");
            String direccion= JOptionPane.showInputDialog("Ingrese la direccion: ");
            String telefono= JOptionPane.showInputDialog("Ingrese el telefono: ");
            String correo= JOptionPane.showInputDialog("Ingrese el correo: ");

            em.getTransaction().begin();

            Cliente cliente= new Cliente();
            cliente.setNombre(nombre);
            cliente.setCedula(cedula);
            cliente.setDireccion(direccion);
            cliente.setTelefono(telefono);
            cliente.setCorreo(correo);

            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("El id del cliente registrado es: "+ cliente.getIdCliente());
            cliente= em.find(Cliente.class, cliente.getIdCliente());
            System.out.println(cliente.toString());

        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    private static void eliminarCliente(){
        EntityManager em= JpaUtil.getEntityManager();
        try {
            Cliente cliente= null;
            int idCliente=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar"));
            cliente= em.find(Cliente.class,idCliente);

                em.getTransaction().begin();
                em.remove(cliente);

                em.getTransaction().commit();

                System.out.println("El Id del cliente eliminado es: " + cliente.getIdCliente());
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    private static void actualizarCliente(){
        EntityManager em= JpaUtil.getEntityManager();
        try {
            Cliente cliente = null;
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a actualizar"));
            cliente = em.find(Cliente.class, idCliente);
            String campoActualizar=JOptionPane.showInputDialog("Ingrese el nombre del campo a actualizar");

            if (cliente!=null){
                em.getTransaction().begin();

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
                em.merge(cliente);
                em.getTransaction().commit();

                System.out.println("El id del cliente actualizado es: "+ cliente.getIdCliente());
                cliente= em.find(Cliente.class, cliente.getIdCliente());
                System.out.println(cliente.toString());

            } else {
                System.out.println("El cliente no existe");
            }
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}
