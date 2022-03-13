package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.repositories.CrudClienteRepository;
import co.edu.cue.webapp.drogueria.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteServiceImpl implements IClienteService{

    EntityManager em;
    CrudRepository<Cliente>  repository;
    public ClienteServiceImpl(EntityManager em) {
        this.em = em;
        repository= new CrudClienteRepository(em);
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Cliente obtenerPorId(int id) {
        return repository.obtenerPorId(id);
    }


    @Override
    public void crearCliente(Cliente cliente) {
       try {
           em.getTransaction().begin();
           repository.create(cliente);
           em.getTransaction().commit();
       }catch (Exception e){
           em.getTransaction().rollback();
           e.printStackTrace();
       }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            repository.update(cliente);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            repository.guardar(cliente);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) throws ClienteException {
        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    @Override
    public Cliente obtenerPorCedula(String cedula) {
        return repository.obtenerPorCedula(cedula);
    }


    //CONSULTAS
    @Override
    public List<Cliente> consulta1(String parametros) {
        return repository.consulta1(parametros);
    }

    @Override
    public long consulta2(long parametros) {
        return repository.consulta2(parametros);
    }

    @Override
    public List<Cliente> consulta3(String parametros) {
        return repository.consulta3(parametros);
    }

    @Override
    public long consulta4(long parametro) {
        return repository.consulta4(parametro);
    }

    @Override
    public Double consulta5(double parametros) {
        return repository.consulta5(parametros);
    }


}
