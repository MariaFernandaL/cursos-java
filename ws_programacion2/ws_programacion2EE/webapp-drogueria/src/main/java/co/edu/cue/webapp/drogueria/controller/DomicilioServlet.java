package co.edu.cue.webapp.drogueria.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;

@WebServlet("/domicilio")
public class DomicilioServlet extends HttpServlet {

    String codigoDomicilio = "";
    String fechaDomicilio = "";
    String direccionDomicilio = "";
    Double costoDomicilio = 0.0;
    String codigoProducto = "";
    String nombreProducto = "";
    Double valorProducto = 0.0;
    Integer cantidadProducto = 0;
    String cliente = "";
    String empleado="";
    Map<String,String> listaErrores= new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        getDataRequest(req);
        validarParametros();

        if (listaErrores.isEmpty()){
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta  chartset=\"UTF-8\">");
                out.println("       <title>Resultados del Domicilio</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Informacion del Domicilio realizado</h1>");
                out.println("   <ul>");
                out.println("   <li>El codigo es: "+ codigoDomicilio+"</li>");
                out.println("   <li>La fecha es: "+ fechaDomicilio+"</li>");
                out.println("   <li>La direccion es: "+ direccionDomicilio+"</li>");
                out.println("   <li>El costo es: "+ costoDomicilio+"</li>");
                out.println("   <li>El codigo del Producto es: "+ codigoProducto+"</li>");
                out.println("   <li>El nombre es: "+ nombreProducto+"</li>");
                out.println("   <li>El valor es: "+ valorProducto+"</li>");
                out.println("   <li>La cantidad es: "+ cantidadProducto+"</li>");
                out.println("   <li>El cliente es: "+ cliente+"</li>");
                out.println("   <li>El empleado es: "+ empleado+"</li>");
                out.println("   <ul>");

                out.println("   </body>");
                out.println("</html>");
            }
        } else {
            req.setAttribute("errores", listaErrores);
            getServletContext().getRequestDispatcher("/transaccion.jsp").forward(req,resp);
        }
    }

    private void getDataRequest(HttpServletRequest req) {
        this.codigoDomicilio= req.getParameter("codigoDomicilio");
        this.fechaDomicilio=req.getParameter("fechaDomicilio");
        this.direccionDomicilio=req.getParameter("direccionDomicilio");
        this.costoDomicilio=Double.parseDouble(req.getParameter("costoDomicilio"));
        this.codigoProducto=req.getParameter("codigoProducto");
        this.nombreProducto=req.getParameter("nombreProducto");
        this.valorProducto=Double.parseDouble(req.getParameter("valorProducto"));
        this.cantidadProducto=Integer.parseInt(req.getParameter("cantidadProducto"));
        this.cliente=req.getParameter("cliente");
        this.empleado=req.getParameter("empleado");
    }

    private void validarParametros() {
        if (codigoDomicilio==null || codigoDomicilio.isBlank()){
            listaErrores.put("codigoDomicilio", "Codigo del domicilio no ingresado");
        }
        if (fechaDomicilio==null || fechaDomicilio.isBlank()){
            listaErrores.put("fechaDomicilio", "Fecha del domicilio no ingresada");
        }
        if (direccionDomicilio==null || direccionDomicilio.isBlank()){
            listaErrores.put("direccionDomicilio", "Direccion del domicilio no ingresada");
        }
        if (costoDomicilio==null || costoDomicilio<=0 || costoDomicilio.equals("")){
            listaErrores.put("costoDomicilio", "Costo del domicilio no ingresado/ Costo del domicilio mal ingresado");
        }
        if (codigoProducto==null || codigoProducto.isBlank()){
            listaErrores.put("codigoProducto", "Codigo del producto no ingresado");
        }
        if (nombreProducto==null || nombreProducto.isBlank()){
            listaErrores.put("nombreProducto", "Nombre del producto no ingresado");
        }
        if (valorProducto==null || valorProducto<=0 || valorProducto.equals("")){
            listaErrores.put("valorProducto", "Valor del producto no ingresado/ Valor del producto mal ingresado");
        }
        if (cantidadProducto<=0 || cantidadProducto==null || cantidadProducto.equals("")){
            listaErrores.put("cantidadProducto", "Cantidad del Producto no ingresado/ Cantidad del producto mal ingresado");
        }
        if (cliente==null || cliente.isBlank()){
            listaErrores.put("cliente", "Cliente no ingresado");
        }
        if (empleado==null || empleado.isBlank()){
            listaErrores.put("empleado", "Empleado no ingresado");
        }
    }
}
