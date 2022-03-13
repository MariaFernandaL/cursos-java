package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Domicilio;
import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;
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

    @Override
    public void create(Domicilio domicilio) {

    }

    @Override
    public void update(Domicilio domicilio) {

    }

    @Override
    public Domicilio obtenerPorCedula(String cedula) {
        return null;
    }

    @Override
    public List<Domicilio> consulta1(String direccion) {
        return null;
    }

    @Override
    public long consulta2(long parametro) {
        return parametro;
    }


    @Override
    public List<Domicilio> consulta3(String parametro) {
        return null;
    }

    @Override
    public long consulta4(long parametro) {
        return 0;
    }

    @Override
    public Double consulta5(double parametro) {
        return null;
    }


}
