package co.edu.cue.webapp.drogueria;

import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import co.edu.cue.webapp.drogueria.services.EmpleadoServiceImpl;
import co.edu.cue.webapp.drogueria.services.IEmpeladoService;
import co.edu.cue.webapp.drogueria.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;

public class MainServicesE {
    public static void main(String[] args) throws EmpleadoException {
        EntityManager em = JpaUtil.getEntityManager();


        IEmpeladoService empleadoService = new EmpleadoServiceImpl(em);

        //CREATE
        Empleado empleado = setDataEmpleado();
        listarEmpleados(empleadoService);
        crearEmpleado(empleadoService, empleado);
        listarEmpleados(empleadoService);

        //UPDATE
        /*Empleado empleado1= setDataActualizar(empleadoService);
        listarEmpleados(empleadoService);
        actualizarEmpleado(empleadoService, empleado1);*/

        //DELETE
        /*int idEmpleado= setDataEliminar(empleadoService);
        listarEmpleados(empleadoService);
        eliminarEmpleado(empleadoService, idEmpleado);
        System.out.println("El empleado fue eliminado");*/

        em.close();
    }

    private static void listarEmpleados(IEmpeladoService empleadoService) {
        List<Empleado> listaEmpleados= empleadoService.listar();
        imprimirListaEmpleados(listaEmpleados);
    }

    private static void crearEmpleado(IEmpeladoService empleadoService, Empleado empleado) {
        empleadoService.guardar(empleado);
    }

    private static void actualizarEmpleado(IEmpeladoService empleadoService, Empleado empleado) {
        empleadoService.guardar(empleado);
    }

    private static void eliminarEmpleado(IEmpeladoService empleadoService, int id) throws EmpleadoException {
        empleadoService.eliminar(id);
    }


    private static Empleado setDataEmpleado() {
        Empleado empleado=null;
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
        String cedula= JOptionPane.showInputDialog("Ingrese la cedula: ");
        String telefono= JOptionPane.showInputDialog("Ingrese el telefono: ");
        String correo= JOptionPane.showInputDialog("Ingrese el correo: ");
        double salario= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario: "));

        empleado= new Empleado();
        empleado.setNombre(nombre);
        empleado.setCedula(cedula);
        empleado.setTelefono(telefono);
        empleado.setCorreo(correo);
        empleado.setSalario(salario);

        return empleado;
    }


    private static Empleado setDataActualizar(IEmpeladoService empleadoService){
        Empleado empleado=null;

        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado a actualizar"));

        empleado=empleadoService.obtenerPorId(idEmpleado);

        String campoActualizar=JOptionPane.showInputDialog("Ingrese el nombre del campo a actualizar");

        if (campoActualizar.equalsIgnoreCase("nombre")){
            String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
            empleado.setNombre(nombre);
        } else if (campoActualizar.equalsIgnoreCase("cedula")){
            String cedula= JOptionPane.showInputDialog("Ingrese la cedula: ");
            empleado.setCedula(cedula);
        }else if (campoActualizar.equalsIgnoreCase("telefono")){
            String telefono= JOptionPane.showInputDialog("Ingrese el telefono: ");
            empleado.setTelefono(telefono);
        }else if (campoActualizar.equalsIgnoreCase("correo")){
            String correo= JOptionPane.showInputDialog("Ingrese el correo: ");
            empleado.setCorreo(correo);
        }
        else if (campoActualizar.equalsIgnoreCase("salario")){
            double salario= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario: "));
            empleado.setSalario(salario);
        }
        return empleado;
    }

    private static int setDataEliminar(IEmpeladoService empleadoService){
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado a eliminar"));
        return idEmpleado;
    }

    private static void imprimirListaEmpleados(List<Empleado> listaEmpleados) {
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
    }
}
