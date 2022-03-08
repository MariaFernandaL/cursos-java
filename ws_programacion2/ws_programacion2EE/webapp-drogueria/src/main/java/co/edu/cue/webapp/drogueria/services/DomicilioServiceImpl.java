package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Domicilio;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;
import co.edu.cue.webapp.drogueria.repositories.CrudDomicilioRepository;
import co.edu.cue.webapp.drogueria.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class DomicilioServiceImpl implements IDomicilioService{

    EntityManager em;
    CrudRepository<Domicilio> repository;

    public DomicilioServiceImpl(EntityManager em) {
        this.em = em;
        repository= new CrudDomicilioRepository(em);
    }


    @Override
    public List<Domicilio> listar() {
        return repository.listar();
    }

    @Override
    public Domicilio obtenerPorId(int id) {
        return repository.obtenerPorId(id);
    }

    @Override
    public void guardar(Domicilio domicilio) {
        try {
            em.getTransaction().begin();
            repository.guardar(domicilio);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) throws DomicilioException {
        try {
            em.getTransaction().begin();
            repository.eliminar(id);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
