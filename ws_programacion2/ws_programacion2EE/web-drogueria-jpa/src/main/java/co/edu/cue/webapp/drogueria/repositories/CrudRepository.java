package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;

import java.util.List;

public interface CrudRepository <T> {

    List<T> listar();
    T obtenerPorId(int id);
    void guardar(T t);
    void eliminar(int id) throws ClienteException, EmpleadoException, ProductoException, DomicilioException;
}
