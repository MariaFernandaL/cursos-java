package co.edu.cue.webapp.servlet.HolaMundo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import java.util.Locale;

@WebServlet("/parametros2/get-url2")
public class Parametros2EjercicioTarea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta  chartset=\"UTF-8\">");
        out.println("       <title>Parametros Nombre, Apellido, Mostrar Fecha</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>Tarea 1: Servlet envio de parametros</h1>");

        if (nombre!=null && apellido!=null) {
            out.println("   <h2>Hola mi nombre es: " + nombre + " " + apellido + "</h2>");
        } else if (nombre!=null){
            out.println("   <h2>Hola mi nombre es: " + nombre +"</h2>");
        } else if (apellido!=null){
            out.println("   <h2>Hola mi apellido es: " +apellido + "</h2>");
        }

        //fecha

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MM ',' yyyy - HH:mm:ss");
        String fechaTexto = formatter.format(date);
        out.println("   <h3>La fecha actual es: "+fechaTexto+"</h3>");
        out.println("   </body>");
        out.println("</html>");
        out.close();
    }
}
