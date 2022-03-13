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

@WebServlet("/cliente/delete")
public class DeleteClienteServlet extends BaseServlet{


    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();


    public DeleteClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cliente cliente = null;
        resp.setContentType("text/html");
        String cedula=req.getParameter("cedulaClienteEliminar");
        validarCampo(cedula);
        try {
            if (listaErrores.isEmpty()){
                cliente = clienteService.obtenerPorCedula(cedula);
                try (PrintWriter out = resp.getWriter()) {
                    clienteService.eliminar(cliente.getIdCliente());
                    responseViewDelete(req, resp, cliente);
                }
            } else {
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            resp.sendError(501,"Información de error"+e.getMessage());
        }

    }

    private void validarCampo(String cedula) {
        if (cedula==null || cedula.isBlank()){
            listaErrores.put("cedulaClienteEliminar", "Cedula del cliente no ingresado");
        }
    }
}
