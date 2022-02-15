package co.edu.cue.webapp.servlet.HolaMundo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/get-url")
public class ParametrosGetServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String saludo = req.getParameter("saludo");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta  chartset=\"UTF-8\">");
        out.println("       <title>Parametros Get de la Url</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>Parametros recibidos</h1>");
        out.println("   <h2>El saludo es: "+ saludo+"</h2>");
        out.println("   </body>");
        out.println("</html>");
        out.close();
    }
}
