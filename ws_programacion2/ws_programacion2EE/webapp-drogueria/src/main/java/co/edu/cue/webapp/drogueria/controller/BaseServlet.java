package co.edu.cue.webapp.drogueria.servlet;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
                out.println("       <h2>Cliente "+cliente.toString()+" </h2>");
            }
            out.println("   </body>");
            out.println("</html>");
        }
    }
}
