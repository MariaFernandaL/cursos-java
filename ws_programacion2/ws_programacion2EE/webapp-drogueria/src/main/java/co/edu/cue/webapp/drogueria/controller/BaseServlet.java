package co.edu.cue.webapp.drogueria.controller;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BaseServlet extends HttpServlet {

    public void responseView(HttpServletRequest req, HttpServletResponse resp, List<Cliente> listaClientes) throws IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Lista de clientes: </h1>");
            for (Cliente cliente: listaClientes) {
                out.println("       <h2>Cliente "+cliente.getIdCliente()+" - "+cliente.getNombre()+" - "+cliente.getCedula()+" - "+cliente.getDireccion()+" - "+cliente.getTelefono()+" - "+cliente.getCorreo()+" - "+cliente.getPago()+" </h2>");
            }
            out.println("   </body>");
            out.println("</html>");
        }
    }

    public void responseView(HttpServletRequest req, HttpServletResponse resp, Cliente cliente) throws IOException {
        resp.setContentType("text/html");

        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Creacion</h1>");
            out.println("       <h2>Cliente creado: "+cliente.getIdCliente()+" - "+cliente.getNombre()+" - "+cliente.getCedula()+" - "+cliente.getDireccion()+" - "+cliente.getTelefono()+" - "+cliente.getCorreo()+" - "+cliente.getPago()+" </h2>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
    public void responseViewUpdate(HttpServletRequest req, HttpServletResponse resp, Cliente cliente) throws IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Actualizado</h1>");
            out.println("       <h2>Cliente actualizado: "+cliente.getIdCliente()+" - "+cliente.getNombre()+" - "+cliente.getCedula()+" - "+cliente.getDireccion()+" - "+cliente.getTelefono()+" - "+cliente.getCorreo()+" - "+cliente.getPago()+" </h2>");
            out.println("   </body>");
            out.println("</html>");
        }
    }

    public void responseViewDelete(HttpServletRequest req, HttpServletResponse resp, Cliente cliente) throws IOException {
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Eliminado</h1>");
            out.println("       <h2>Cliente eliminado con exito</h2>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
    public Cliente getDataClienteRequest(Cliente cliente, HttpServletRequest req)throws Exception, ClienteException {
        cliente= new Cliente();
        cliente.setNombre(req.getParameter("nombreCliente"));
        cliente.setCedula(req.getParameter("cedulaCliente"));
        cliente.setDireccion(req.getParameter("direccionCliente"));
        cliente.setTelefono(req.getParameter("telefonoCliente"));
        cliente.setCorreo(req.getParameter("correoCliente"));
        cliente.setPago(Double.parseDouble(req.getParameter("pagoCliente")));
        return cliente;
    }


    //CONSULTAS

    public void responseViewConsulta13(HttpServletRequest req, HttpServletResponse resp, List<Cliente> cliente) throws IOException{
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Consulta 1-3</h1>");
            out.println("       <h2>Consulta realizada con exito</h2>");
            out.println("       <h3>Clientes:</h3>");
            for (Cliente cliente1: cliente) {
                out.println("       <h2>Cliente "+cliente1.getIdCliente()+" - "+cliente1.getNombre()+" - "+cliente1.getCedula()+" - "+cliente1.getDireccion()+" - "+cliente1.getTelefono()+" - "+cliente1.getCorreo()+" - "+cliente1.getPago()+" </h2>");
            }
            out.println("   </body>");
            out.println("</html>");
        }
    }

    public void responseViewConsulta24(HttpServletRequest req, HttpServletResponse resp, long respuesta) throws IOException{
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Consulta 2-4</h1>");
            out.println("       <h2>Consulta realizada con exito</h2>");
            out.println("       <h3>Cantidad: "+respuesta+"</h3>");
            out.println("   </body>");
            out.println("</html>");
        }
    }
    public void responseViewConsulta5(HttpServletRequest req, HttpServletResponse resp, double respuesta) throws IOException{
        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("   <head>");
            out.println("       <meta  chartset=\"UTF-8\">");
            out.println("       <title>INFORMACION BD</title>");
            out.println("   </head>");
            out.println("   <body>");
            out.println("       <h1>Consulta 5</h1>");
            out.println("       <h2>Consulta realizada con exito</h2>");
            out.println("       <h3>Promedio: "+respuesta+"</h3>");
            out.println("   </body>");
            out.println("</html>");
        }
    }

}
