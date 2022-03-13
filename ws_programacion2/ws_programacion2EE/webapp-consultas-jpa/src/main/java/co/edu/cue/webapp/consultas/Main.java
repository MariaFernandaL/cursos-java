package co.edu.cue.webapp.consultas;

import co.edu.cue.webapp.consultas.entity.Cliente;
import co.edu.cue.webapp.consultas.entity.Employee;
import co.edu.cue.webapp.consultas.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //obtenerEmpleados();
        //obtenerEmpleadosConNombreD();
        //obtenerEmpleadosNominaTotalDep50();
        //obtenerNombresEmail();
        //obtenerPromedioSalario();
        //obtenerTotalEmpleados();
        //obtenerPorIdyJob();
        //obtenerTituloTrabajo();
        //obtenerPorIdYSalario();
        //obtenerPorIdNombreYMinDate();
        //obtenerNombreSYDireccionArmenia();
    }
    
    private static void obtenerEmpleados(){
        List<Employee> listaEmpleados = null;
        EntityManager em= JpaUtil.getEntityManager();
        
        listaEmpleados= em.createQuery("select e from Employee e", Employee.class).getResultList();
        imprimirListaEmpleados(listaEmpleados);
        em.close();
    }

    private static void obtenerEmpleadosConNombreD(){
        List<String> listaEmpleados = null;
        EntityManager em= JpaUtil.getEntityManager();
        listaEmpleados= em.createQuery("SELECT DISTINCT e.firstName FROM Employee e WHERE e.firstName like 'D%' order by e.firstName Desc", String.class).getResultList();
        imprimirEmpleadosString(listaEmpleados);
        em.close();
    }

    private static void obtenerEmpleadosNominaTotalDep50(){
        Double sumaNomina=null;
        EntityManager em= JpaUtil.getEntityManager();
        sumaNomina= em.createQuery("SELECT SUM(e.salary) FROM Employee e WHERE e.idDepartament=50", Double.class).getSingleResult();
        System.out.println(sumaNomina.toString());
    }

    private static void obtenerNombresEmail(){
        List<Employee> listaNombres=null;
        EntityManager em= JpaUtil.getEntityManager();
        listaNombres= em.createQuery("SELECT NEW co.edu.cue.webapp.consultas.entity.Employee(e.firstName, e.lastName, e.email) FROM Employee e WHERE e.hireDate>= '2007-01-01' and e.hireDate < '2008-12-31' and e.firstName Like 'L%' order by e.lastName ASC", Employee.class).getResultList();
        imprimirNombresEmail(listaNombres);
        em.close();
    }


    private static void obtenerPromedioSalario(){
        Double promedioSalario=null;
        EntityManager em= JpaUtil.getEntityManager();
        promedioSalario= em.createQuery("SELECT AVG(e.salary) FROM Employee e WHERE e.idDepartament=30 or e.idDepartament=50 or e.idDepartament=100", Double.class).getSingleResult();
        System.out.println(promedioSalario.toString());
        em.close();
    }

    private static void obtenerTotalEmpleados(){
        Long totalEmpleados=null;
        EntityManager em= JpaUtil.getEntityManager();
        totalEmpleados= em.createQuery("SELECT COUNT(e.idEmployee) FROM Employee e WHERE e.idDepartament=50 AND (e.idJob=1 OR e.idJob=2 OR e.idJob=3 OR e.idJob=4 OR e.idJob=5) AND e.salary>=3000", Long.class).getSingleResult();
        System.out.println(totalEmpleados);
        em.close();
    }

    private static void obtenerPorIdyJob(){
        List<Employee> listaNombres=null;
        EntityManager em= JpaUtil.getEntityManager();
        listaNombres= em.createQuery("SELECT NEW co.edu.cue.webapp.consultas.entity.Employee(e.idEmployee, e.idJob) FROM Employee e WHERE e.idJob>=2", Employee.class).getResultList();
        imprimirIdYJobYIdEmpleado(listaNombres);
        em.close();
    }

    private static void obtenerTituloTrabajo(){
        List<String> listaTituloTrabajo = null;
        EntityManager em= JpaUtil.getEntityManager();
        listaTituloTrabajo= em.createQuery("SELECT j.jobTitle FROM Job j WHERE j.minSalary between '8000' and '20000' and j.maxSalary>=12000", String.class).getResultList();
        imprimirEmpleadosString(listaTituloTrabajo);
        em.close();
    }

    private static void obtenerPorIdYSalario(){
        List<Employee> listaIdYSalario=null;
        EntityManager em= JpaUtil.getEntityManager();
        listaIdYSalario= em.createQuery("SELECT NEW co.edu.cue.webapp.consultas.entity.Employee(e.idEmployee, e.salary) FROM Employee e ORDER BY e.salary DESC", Employee.class).setMaxResults(5).getResultList();
        imprimirIdYJobYSalario(listaIdYSalario);
        em.close();
    }

    private static void obtenerPorIdNombreYMinDate(){
        Employee employee=null;
        EntityManager em= JpaUtil.getEntityManager();
        employee= em.createQuery("SELECT NEW co.edu.cue.webapp.consultas.entity.Employee(e.idEmployee, e.firstName, MIN(e.hireDate)) FROM Employee e", Employee.class).getSingleResult();
        System.out.println(employee.listarIdEmpleadoYNombreYFecha());
        em.close();
    }


    private static void obtenerNombreSYDireccionArmenia(){
        List<Cliente> cliente= null;
        EntityManager em= JpaUtil.getEntityManager();
        cliente= em.createQuery("SELECT NEW co.edu.cue.webapp.consultas.entity.Cliente(c.nombre, c.direccion) FROM Cliente c WHERE c.nombre like 's%' and c.direccion ='armenia'", Cliente.class).getResultList();
        imprimirClientes(cliente);
        em.close();
    }

    private static void imprimirEmpleadosString(List<String> listaEmpleados) {
        for (String empleado: listaEmpleados) {
            System.out.println(empleado.toString());
        }
    }

    private static void imprimirListaEmpleados(List<Employee> listaEmpleados ){
        for (Employee employee: listaEmpleados) {
            System.out.println(employee.toString());
        }
    }

    private static void imprimirNombresEmail(List<Employee> listaNombres) {
        for (Employee employee: listaNombres) {
            System.out.println(employee.listarNombresEmail());
        }
    }

    private static void imprimirIdYJobYIdEmpleado(List<Employee> lista) {
        for (Employee employee: lista) {
            System.out.println(employee.listarIdYJobYIdEmpleado());
        }
    }

    private static void imprimirIdYJobYSalario(List<Employee> lista) {
        for (Employee employee: lista) {
            System.out.println(employee.listarIdYJobYSalario());
        }
    }

    private static void imprimirClientes(List<Cliente> lista) {
        for (Cliente cliente: lista) {
            System.out.println(cliente.listarClientes());
        }
    }

}
