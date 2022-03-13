package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;

import java.util.List;

public interface IClienteService {

    List<Cliente> listar();
    Cliente obtenerPorId(int id);
    void guardar(Cliente cliente);
    void eliminar(int id) throws ClienteException;
}
