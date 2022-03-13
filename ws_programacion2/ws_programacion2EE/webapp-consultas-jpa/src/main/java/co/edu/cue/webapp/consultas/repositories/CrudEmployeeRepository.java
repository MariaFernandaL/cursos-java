package co.edu.cue.webapp.consultas.repositories;
import co.edu.cue.webapp.consultas.entity.Employee;
import co.edu.cue.webapp.consultas.exceptions.EmployeeException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudEmployeeRepository implements ICrudRepository<Employee>{
    EntityManager em;
    public CrudEmployeeRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Employee> listar() {
        return em.createQuery("select e from Employee e").getResultList();
    }
    @Override
    public Employee obtenerPorId(int id) {
        return em.find(Employee.class, id);
    }
    @Override
    public void guardar(Employee empleado) {
        if (empleado!=null && empleado.getIdEmployee()>0){
            em.merge(empleado);
        } else {
            em.persist(empleado);
        }
    }
    @Override
    public void eliminar(int id) throws EmployeeException {
        Employee empleado= obtenerPorId(id);
        if (empleado==null){
            throw new EmployeeException("El empleado a eliminar no existe");
        } else {
            em.remove(empleado);
        }
    }
}