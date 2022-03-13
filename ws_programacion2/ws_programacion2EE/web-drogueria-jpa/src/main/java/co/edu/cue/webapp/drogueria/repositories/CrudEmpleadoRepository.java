package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudEmpleadoRepository implements CrudRepository<Empleado>{
    EntityManager em;


    public CrudEmpleadoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Empleado> listar() {
        return em.createQuery("select c from Empleado c").getResultList();
    }

    @Override
    public Empleado obtenerPorId(int id) {
        return em.find(Empleado.class, id);
    }

    @Override
    public void guardar(Empleado empleado) {
        if (empleado!=null && empleado.getIdEmpleado()>0){
            em.merge(empleado);
        } else {
            em.persist(empleado);
        }
    }

    @Override
    public void eliminar(int id) throws EmpleadoException{
        Empleado empleado= obtenerPorId(id);
        if (empleado==null){
            throw new EmpleadoException("El empleado a eliminar no existe");
        } else {
            em.remove(empleado);
        }
    }
}
