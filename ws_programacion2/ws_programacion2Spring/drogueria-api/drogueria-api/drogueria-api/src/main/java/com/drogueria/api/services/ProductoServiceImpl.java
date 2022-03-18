package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Producto;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.ProductoException;
import com.drogueria.api.repositories.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoRepository productoRepository;
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		return (List<Producto>)productoRepository.findAll();
	}
	

	@Override
	@Transactional
	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	@Transactional
	public Producto findById(int id) {
		return productoRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void update(Producto producto, int id) throws ProductoException{
		if (findById(id)==null) {
			throw new ProductoException("El producto no existe");
		}
		productoRepository.save(producto);
	}

	@Override
	@Transactional
	public void delete(int id) {
		productoRepository.deleteById(id);
	}

}
