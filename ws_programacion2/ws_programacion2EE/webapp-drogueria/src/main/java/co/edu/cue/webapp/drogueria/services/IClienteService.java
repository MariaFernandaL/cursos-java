package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;

import java.util.List;

public interface IClienteService {

    List<Cliente> listar();
    Cliente obtenerPorId(int id);
    void guardar(Cliente cliente);
    void eliminar(int id) throws ClienteException;

    void crearCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    Cliente obtenerPorCedula(String cedula);

    //CONSULTAS
    List<Cliente> consulta1(String parametros);
    long consulta2(long parametros);
    List<Cliente> consulta3(String parametros);
    long consulta4(long parametro);
    Double consulta5(double parametros);
}
