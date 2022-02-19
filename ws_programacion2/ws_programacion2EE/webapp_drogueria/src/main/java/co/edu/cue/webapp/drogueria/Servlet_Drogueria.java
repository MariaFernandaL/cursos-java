package co.edu.cue.webapp.drogueria;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/proyecto/drogueria")
public class Servlet_Drogueria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta  chartset=\"UTF-8\">");
        out.println("       <title>Drogueria</title>");
        out.println("   </head>");
        out.println("   <body bgcolor=\"PaleGreen\">");
        out.println("       <h1 style=\"text-align:center\">Formulario drogueria</h1>");
        out.println("   <h3>Numero de Domicilio: <input type=\"text\" name=\"numeroDomicilio\"/></h3>");
        out.println("   <h3>Fecha: <input type=\"date\" name=\"fecha\"/></h3>");
        out.println("   <h3>Empleado: <input type=\"text\" name=\"empleado\"/></h3>");
        out.println("   <h3>Producto: <input type=\"text\" name=\"producto\"/></h3>");
        out.println("   <h3>Cliente: <input type=\"text\" name=\"cliente\"/></h3>");
        out.print("   <input type=\"button\" value=\"Actualizar\">");
        out.print("   <input type=\"button\" value=\"Eliminar\">");
        out.print("   <input type=\"button\" value=\"Agregar\">");
        out.print("   <input type=\"button\" value=\"Nuevo\">");
        out.println("   </body>");
        out.println("</html>");
        out.close();
    }
}
