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
        out.println("   <body>");
        out.println("       <h1 style=\"text-align:center\">Formulario drogueria</h1>");
        out.println("   <h2>Cliente: "+"</h2>");
        out.println("   <h2>Cliente: "+"</h2>");
        out.prin
        out.println("</html>");
        out.close();
    }
}
