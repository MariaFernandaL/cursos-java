package co.edu.cue.webapp.drogueria.servlet;


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
import java.util.List;

@WebServlet("/cliente")
public class GetClientesServlet extends BaseServlet{

    EntityManager em;
    IClienteService clienteService;

    public GetClientesServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        List<Cliente> listaClientes= clienteService.listar();

        if (!listaClientes.isEmpty()){
            responseView(req,resp,listaClientes);
        }else {
            resp.sendError(501, "No existe informacion de clientes");
        }

    }
}
