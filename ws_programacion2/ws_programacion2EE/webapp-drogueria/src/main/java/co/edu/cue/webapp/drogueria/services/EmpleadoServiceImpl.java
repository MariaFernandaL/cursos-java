package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import co.edu.cue.webapp.drogueria.repositories.CrudEmpleadoRepository;
import co.edu.cue.webapp.drogueria.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmpleadoServiceImpl implements IEmpeladoService{

    EntityManager em;
    CrudRepository<Empleado> repository;
    public EmpleadoServiceImpl(EntityManager em) {
        this.em = em;
        repository= new CrudEmpleadoRepository(em);
    }


    @Override
    public List<Empleado> listar() {
        return repository.listar();
    }

    @Override
    public Empleado obtenerPorId(int id) {
        return obtenerPorId(id);
    }

    @Override
    public void guardar(Empleado empleado) {
        try {
            em.getTransaction().begin();
            repository.guardar(empleado);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) throws EmpleadoException {
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
