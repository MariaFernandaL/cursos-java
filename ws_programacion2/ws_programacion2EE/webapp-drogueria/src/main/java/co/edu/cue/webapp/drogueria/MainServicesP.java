package co.edu.cue.webapp.drogueria;


import co.edu.cue.webapp.drogueria.entity.Producto;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;
import co.edu.cue.webapp.drogueria.services.IProductoService;
import co.edu.cue.webapp.drogueria.services.ProductoServiceImpl;
import co.edu.cue.webapp.drogueria.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;

public class MainServicesP {
    public static void main(String[] args) throws ProductoException {

        EntityManager em = JpaUtil.getEntityManager();

        IProductoService productoService = new ProductoServiceImpl(em);

        //CREATE
        Producto producto = setDataProducto();
        listarProductos(productoService);
        crearProducto(productoService, producto);
        listarProductos(productoService);

        //UPDATE
        /*Producto producto1= setDataActualizar(productoService);
        listarProductos(productoService);
        actualizarProducto(productoService, producto1);

        //DELETE
        int idProducto= setDataEliminar(productoService);
        listarProductos(productoService);
        eliminarProducto(productoService, idProducto);
        System.out.println("El empleado fue eliminado");*/

        em.close();
    }

    private static void listarProductos(IProductoService productoService) {
        List<Producto> listaProductos= productoService.listar();
        imprimirListaProductos(listaProductos);
    }

    private static void crearProducto(IProductoService productoService, Producto producto) {
        productoService.guardar(producto);
    }

    private static void actualizarProducto(IProductoService productoService, Producto producto) {
        productoService.guardar(producto);
    }

    private static void eliminarProducto(IProductoService productoService , int id) throws ProductoException {
        productoService.eliminar(id);
    }


    private static Producto setDataProducto() {
        Producto producto=null;
        String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
        String codigo=JOptionPane.showInputDialog("Ingrese el codigo: ");
        double valorU= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por unidad: "));
        int cantidad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));

        producto= new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setValorUnidad(valorU);
        producto.setCantidad(cantidad);

        return producto;
    }


    private static Producto setDataActualizar(IProductoService productoService){
        Producto producto=null;

        int idProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto a actualizar"));

        producto=productoService.obtenerPorId(idProducto);

        String campoActualizar=JOptionPane.showInputDialog("Ingrese el nombre del campo a actualizar");

        if (campoActualizar.equalsIgnoreCase("nombre")){
            String nombre= JOptionPane.showInputDialog("Ingrese el nombre: ");
            producto.setNombre(nombre);
        } else if (campoActualizar.equalsIgnoreCase("codigo")){
            String codigo= JOptionPane.showInputDialog("Ingrese el codigo: ");
            producto.setCodigo(codigo);
        }else if (campoActualizar.equalsIgnoreCase("valorU")){
            double valorU= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por unidad: "));
            producto.setValorUnidad(valorU);
        }else if (campoActualizar.equalsIgnoreCase("cantidad")){
            int cantidad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
            producto.setCantidad(cantidad);
        }

        return producto;
    }

    private static int setDataEliminar(IProductoService productoService){
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado a eliminar"));
        return idEmpleado;
    }

    private static void imprimirListaProductos(List<Producto> listaProductos) {
        for (Producto producto : listaProductos) {
            System.out.println(producto.toString());
        }
    }
}

