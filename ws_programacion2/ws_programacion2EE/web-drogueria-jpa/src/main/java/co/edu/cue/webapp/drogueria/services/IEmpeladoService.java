package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;

import java.util.List;

public interface IEmpeladoService {
    List<Empleado> listar();
    Empleado obtenerPorId(int id);
    void guardar(Empleado empleado);
    void eliminar(int id) throws EmpleadoException;
}
