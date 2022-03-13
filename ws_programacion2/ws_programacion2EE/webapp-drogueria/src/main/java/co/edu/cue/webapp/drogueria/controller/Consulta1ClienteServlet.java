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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cliente/consulta1")
public class Consulta1ClienteServlet extends BaseServlet{


    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();
    String parametro;

    public Consulta1ClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Cliente> listacliente = null;
        resp.setContentType("text/html");
        parametro=req.getParameter("cConsulta1");

        validarParametros(parametro);
        try{
            if (listaErrores.isEmpty()){
                listacliente= clienteService.consulta1(parametro);
                responseViewConsulta13(req, resp, listacliente);
            } else {
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
        }catch (Exception e){
            resp.sendError(501,"Información de error"+e.getMessage());
        }
    }

    private void validarParametros(String cedula) {
        if(cedula==null || cedula.isBlank()){
            listaErrores.put("cConsulta1", "Parametro no ingresado");
        }
    }


}
