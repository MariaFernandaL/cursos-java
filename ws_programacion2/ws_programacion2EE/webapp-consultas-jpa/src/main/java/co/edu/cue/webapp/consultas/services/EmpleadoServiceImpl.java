package co.edu.cue.webapp.consultas.services;

import co.edu.cue.webapp.consultas.entity.Employee;
import co.edu.cue.webapp.consultas.exceptions.EmployeeException;
import co.edu.cue.webapp.consultas.repositories.CrudEmployeeRepository;
import co.edu.cue.webapp.consultas.repositories.ICrudRepository;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmpleadoServiceImpl implements IEmployeeService{
    EntityManager em;
    ICrudRepository<Employee> repository;
    public EmpleadoServiceImpl(EntityManager em) {
        this.em = em;
        repository= new CrudEmployeeRepository(em);
    }
    @Override
    public List<Employee> listar() {
        return repository.listar();
    }
    @Override
    public Employee obtenerPorId(int id) {
        return repository.obtenerPorId(id);
    }
    @Override
    public void guardar(Employee employee) {
        try {
            em.getTransaction().begin();
            repository.guardar(employee);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void eliminar(int id) throws EmployeeException {
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
