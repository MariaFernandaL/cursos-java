package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudClienteRepository implements CrudRepository<Cliente>{
    EntityManager em;

    public CrudClienteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c").getResultList();
    }

    @Override
    public Cliente obtenerPorId(int id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente cliente) {
        if (cliente!=null && cliente.getIdCliente()>0){
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Override
    public void eliminar(int id) throws ClienteException {
        Cliente cliente= obtenerPorId(id);
        if (cliente==null){
            throw new ClienteException("El cliente a eliminar no existe");
        } else {
            em.remove(cliente);
        }
    }

    @Override
    public void create(Cliente cliente) {
        em.persist(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    @Override
    public Cliente obtenerPorCedula(String cedula) {
        Cliente cliente=null;
       cliente=(Cliente)em.createQuery("SELECT c FROM Cliente c WHERE cedula="+cedula).getSingleResult();
        return cliente;
    }


    //CONSULTAS
//SELECT * FROM drogueria.cliente WHERE nombre like 's%' ORDER BY nombre desc;
    @Override
    public List<Cliente> consulta1(String parametro) {
       return em.createQuery("SELECT c FROM Cliente c WHERE nombre like '"+parametro+"%'order by nombre desc").getResultList();
    }


//SELECT count(pago) as CANTIDAD FROM drogueria.cliente WHERE PAGO=4000 group by pago;
    @Override
    public long consulta2(long parametro) {
        return (long) em.createQuery("SELECT COUNT(pago) FROM Cliente c WHERE pago="+parametro+" group by pago").getSingleResult();
    }


//SELECT * FROM drogueria.cliente WHERE pago between 5000 and 10000 and nombre like 's%';
    @Override
    public List<Cliente> consulta3(String parametro) {
        return em.createQuery("SELECT c FROM Cliente c WHERE pago between 5000 and "+Double.parseDouble(parametro)+" and nombre like 's%'order by nombre desc").getResultList();
    }



//select count(pago)  from drogueria.cliente group by pago having count(pago)=1;

    @Override
    public long consulta4(long parametro) {
        return (long) em.createQuery("SELECT COUNT(pago) FROM Cliente c group by pago having count(pago)="+parametro).getSingleResult();
    }


//SELECT AVG(pago) as PROMEDIO FROM drogueria.cliente WHERE pago between 5000 and 10000 and nombre like 's%';
    @Override
    public Double consulta5(double parametro) {
        return (Double)em.createQuery("SELECT AVG(pago) FROM Cliente c WHERE pago between 5000 and "+parametro+"  and nombre like 's%'").getSingleResult();
    }
}