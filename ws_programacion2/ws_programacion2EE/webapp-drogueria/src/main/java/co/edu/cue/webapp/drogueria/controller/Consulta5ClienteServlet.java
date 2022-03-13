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

@WebServlet("/cliente/consulta5")
public class Consulta5ClienteServlet extends BaseServlet{


    EntityManager em;
    IClienteService clienteService;
    Map<String,String> listaErrores= new HashMap<>();
    Double parametro;

    public Consulta5ClienteServlet() {
        this.em= JpaUtil.getEntityManager();
        this.clienteService= new ClienteServiceImpl(em);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double resultado=null;
        resp.setContentType("text/html");
        parametro=Double.parseDouble(req.getParameter("consulta5"));

        validarParametros(parametro);
        try{
            if (listaErrores.isEmpty()){
                resultado= clienteService.consulta5(parametro);
                responseViewConsulta5(req, resp, resultado);
            } else {
                req.setAttribute("errores", listaErrores);
                getServletContext().getRequestDispatcher("/cliente.jsp").forward(req,resp);
            }
        }catch (Exception e){
            resp.sendError(501,"Información de error"+e.getMessage());
        }
    }

    private void validarParametros(Double parametro) {
        if(parametro==null || parametro==0.0){
            listaErrores.put("consulta2", "Parametro no ingresado");
        }
    }
}
