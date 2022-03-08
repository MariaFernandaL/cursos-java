package co.edu.cue.webapp.drogueria.services;


import co.edu.cue.webapp.drogueria.entity.Domicilio;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;

import java.util.List;

public interface IDomicilioService {
    List<Domicilio> listar();
    Domicilio obtenerPorId(int id);
    void guardar(Domicilio domicilio);
    void eliminar(int id) throws DomicilioException;
}
