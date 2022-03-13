package co.edu.cue.webapp.consultas.repositories;
import co.edu.cue.webapp.consultas.exceptions.EmployeeException;

import java.util.List;

public interface ICrudRepository <T> {
    List<T> listar();
    T obtenerPorId(int id);
    void guardar(T t);
    void eliminar(int id) throws EmployeeException;
}