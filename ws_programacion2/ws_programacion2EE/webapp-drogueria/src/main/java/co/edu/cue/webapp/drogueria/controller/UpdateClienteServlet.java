package co.edu.cue.webapp.drogueria.controller;
import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.services.ClienteServiceImpl;
import co.edu.cue.webapp.drogueria.services.IClienteService;
import co.edu.cue.webapp.drogueria.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cliente/update")
public class UpdateClienteServlet extends BaseServlet{
    EntityManager em;
    IClienteService clienteService;
   Map<String,String> listaErrores= new HashMap<>();
   String nombre;
   String cedula;
   String telefono;
   String direccion;
   String correo;
   Double pago;

    public UpdateClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            obtenerDatos(req);
            if (listaErrores.isEmpty()) {
                try (PrintWriter out = resp.getWriter()) {
                    Cliente cliente = null;
                    resp.setContentType("text/html");
                    try {
                        cliente = clienteService.obtenerPorCedula(req.getParameter("cedulaClienteAct"));
                        datosNulos(req, resp, cliente);
                        if (cliente != null) {
                            setDatosEmpleado(req, resp, cliente);
                            clienteService.guardar(cliente);
                            responseViewUpdate(req, resp, cliente);
                        }
                    } catch (Exception e) {
                        resp.sendError(501, "Informacion de error" + e.getMessage());
                    }
                }
            }else{
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
    }
    private void obtenerDatos(HttpServletRequest req) {
        this.nombre=req.getParameter("nombreClienteAct");
        this.cedula=req.getParameter("cedulaClienteAct");
        this.telefono=req.getParameter("telefonoClienteAct");
        this.direccion=req.getParameter("direccionClienteAct");
        this.correo=req.getParameter("correoClienteAct");
        this.pago=Double.parseDouble(req.getParameter("pagoClienteAct"));
    }

    private void setDatosEmpleado(HttpServletRequest req, HttpServletResponse resp, Cliente cliente) {
        cliente.setNombre(nombre);
        cliente.setCedula(cedula);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCorreo(correo);
        cliente.setPago(pago);
    }

    private void datosNulos(HttpServletRequest req, HttpServletResponse resp, Cliente cliente) {
        if (nombre==null|| this.nombre.isBlank()){
            this.nombre=cliente.getNombre();
        }
        if (cedula== null || this.cedula.isBlank()) {
            this.cedula=cliente.getCedula();
        }
        if (direccion== null || this.direccion.isBlank()) {
            this.direccion=cliente.getDireccion();
        }
        if (telefono== null || this.telefono.isBlank()) {
            this.telefono=cliente.getTelefono();
        }
        if (correo== null || this.correo.isBlank()) {
            this.correo=cliente.getCorreo();
        }
        if (pago== null || this.pago==0.0) {
            this.pago=cliente.getPago();
        }


    }
}


