package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.entity.Domicilio;
import co.edu.cue.webapp.drogueria.entity.Producto;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudDomicilioRepository implements CrudRepository<Domicilio>{
    EntityManager em;

    public CrudDomicilioRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Domicilio> listar() {
        return em.createQuery("select c from Domicilio c").getResultList();
    }

    @Override
    public Domicilio obtenerPorId(int id) {
        return em.find(Domicilio.class, id);
    }

    @Override
    public void guardar(Domicilio domicilio) {
        if (domicilio!=null && domicilio.getIdDomicilio()>0){
            em.merge(domicilio);
        } else {
            em.persist(domicilio);
        }
    }

    @Override
    public void eliminar(int id) throws DomicilioException {
        Domicilio domicilio= obtenerPorId(id);
        if (domicilio==null){
            throw new DomicilioException("El domicilio a eliminar no existe");
        } else {
            em.remove(domicilio);
        }
    }
}
