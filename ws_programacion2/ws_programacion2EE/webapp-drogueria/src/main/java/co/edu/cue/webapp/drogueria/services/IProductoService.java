package co.edu.cue.webapp.drogueria.services;

import co.edu.cue.webapp.drogueria.entity.Producto;
import co.edu.cue.webapp.drogueria.exceptions.ProductoException;

import java.util.List;

public interface IProductoService {
    List<Producto> listar();
    Producto obtenerPorId(int id);
    void guardar(Producto producto);
    void eliminar(int id) throws ProductoException;
}

