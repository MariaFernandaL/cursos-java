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


@WebServlet("/cliente/create")
public class CreateClienteServlet extends BaseServlet{
    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();
    public CreateClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cliente = null;
        resp.setContentType("text/html");
        try {
            cliente = getDataClienteRequest(cliente,req);
            validarParametros(cliente);
            if (listaErrores.isEmpty()){
                try (PrintWriter out = resp.getWriter()) {
                    clienteService.crearCliente(cliente);
                    responseView(req,resp,cliente);
                }
            } else {
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            resp.sendError(501,"Información de error"+e.getMessage());
        }
    }
    private void validarParametros(Cliente cliente) {
        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            listaErrores.put("nombreCliente", "Nombre del cliente no ingresado");
        }
        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            listaErrores.put("cedulaCliente", "Cedula del cliente no ingresado");
        }
        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            listaErrores.put("telefonoCliente", "Telefono del cliente no ingresado");
        }
        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            listaErrores.put("direccionCliente", "Direccion del cliente no ingresado");
        }
        if(cliente.getNombre()==null || cliente.getNombre().isBlank()){
            listaErrores.put("correoCliente", "Correo del cliente no ingresado");
        }
        if(cliente.getPago()==null|| cliente.getPago()==0.0){
            listaErrores.put("pagoCliente", "Pago del cliente no ingresado");
        }
    }


}
