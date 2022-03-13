package co.edu.cue.webapp.drogueria.controller;

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
import java.util.Map;

@WebServlet("/cliente/consulta4")
public class Consulta4ClienteServlet extends BaseServlet{


    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();
    long parametro;

    public Consulta4ClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long resultado=0;
        resp.setContentType("text/html");
        parametro=Long.parseLong(req.getParameter("consulta4"));
        validarParametros(parametro);
        try{
            if (listaErrores.isEmpty()){
                resultado= clienteService.consulta4(parametro);
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
            listaErrores.put("consulta4", "Parametro no ingresado");
        }
    }

}
