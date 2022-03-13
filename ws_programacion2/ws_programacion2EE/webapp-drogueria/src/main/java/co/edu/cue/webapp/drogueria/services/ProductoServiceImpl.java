package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Producto;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;
import co.edu.cue.webapp.drogueria.repositories.CrudProductoRepository;
import co.edu.cue.webapp.drogueria.repositories.CrudRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductoServiceImpl implements IProductoService{

    EntityManager em;
    CrudRepository<Producto> repository;

    public ProductoServiceImpl(EntityManager em) {
        this.em = em;
        repository= new CrudProductoRepository(em);
    }


    @Override
    public List<Producto> listar() {
        return repository.listar();
    }

    @Override
    public Producto obtenerPorId(int id) {
        return repository.obtenerPorId(id);
    }

    @Override
    public void guardar(Producto producto) {
        try {
            em.getTransaction().begin();
            repository.guardar(producto);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) throws ProductoException {
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
