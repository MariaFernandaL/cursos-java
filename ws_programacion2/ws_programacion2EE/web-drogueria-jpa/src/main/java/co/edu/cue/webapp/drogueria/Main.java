package co.edu.cue.webapp.drogueria.util;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        obtenerClientes();
        //obtenerClientePorId();
        //obtenerClientePorIdWhere();
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


        Query query= em.createQuery("select c from Cliente c where c.idCliente=" + id, Cliente.class);

        List<Cliente> listaClientes = query.getResultList();

        imprimirListaClientes(listaClientes);
        em.close();
    }

    private static void imprimirListaClientes(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.toString());
        }
    }
}
