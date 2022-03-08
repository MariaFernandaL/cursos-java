package co.edu.cue.webapp.drogueria.repositories;

import co.edu.cue.webapp.drogueria.entity.Cliente;
import co.edu.cue.webapp.drogueria.entity.Empleado;
import co.edu.cue.webapp.drogueria.entity.Producto;
import co.edu.cue.webapp.drogueria.exceptions.ClienteException;
import co.edu.cue.webapp.drogueria.exceptions.DomicilioException;
import co.edu.cue.webapp.drogueria.exceptions.EmpleadoException;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CrudProductoRepository implements CrudRepository<Producto>{

    EntityManager em;

    public CrudProductoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Producto> listar() {
        return em.createQuery("select c from Producto c").getResultList();
    }

    @Override
    public Producto obtenerPorId(int id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) {
            if (producto!=null && producto.getIdProducto()>0){
                em.merge(producto);
            } else {
                em.persist(producto);
            }
    }

    @Override
    public void eliminar(int id) throws   ProductoException{
        Producto producto= obtenerPorId(id);
        if (producto==null){
            throw new ProductoException("El producto a eliminar no existe");
        } else {
            em.remove(producto);
        }
    }
}
