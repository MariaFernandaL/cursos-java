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

@WebServlet("/cliente/consulta2")
public class Consulta2ClienteServlet extends BaseServlet{


    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();
    long parametro;

    public Consulta2ClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long resultado=0;
        resp.setContentType("text/html");
        parametro=Long.parseLong(req.getParameter("consulta2"));

        validarParametros(parametro);
        try{
            if (listaErrores.isEmpty()){
                resultado= clienteService.consulta2(parametro);
                responseViewConsulta24(req, resp, resultado);
            } else {
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
        }catch (Exception e){
            resp.sendError(501,"Información de error"+e.getMessage());
        }
    }

    private void validarParametros(Long parametro) {
        if(parametro==null){
            listaErrores.put("consulta2", "Parametro no ingresado");
        }
    }
}
