package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Producto;
import com.drogueria.api.exception.ProductoException;

public interface IProductoService {

	public List<Producto> findAll();
	public void save(Producto producto);
	public Optional<Producto> findById(int id);
	void update(Producto producto, int id) throws ProductoException;
	void delete(int id);
}
