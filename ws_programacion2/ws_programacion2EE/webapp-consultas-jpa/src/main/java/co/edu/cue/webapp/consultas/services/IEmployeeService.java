package co.edu.cue.webapp.consultas.services;
import co.edu.cue.webapp.consultas.entity.Employee;
import co.edu.cue.webapp.consultas.exceptions.EmployeeException;

import java.util.List;

public interface IEmployeeService {
    List<Employee> listar();
    Employee obtenerPorId(int id);
    void guardar(Employee employee);
    void eliminar(int id) throws EmployeeException;
}