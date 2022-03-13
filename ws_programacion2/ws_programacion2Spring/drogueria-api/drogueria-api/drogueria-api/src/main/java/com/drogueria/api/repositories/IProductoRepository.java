package com.drogueria.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.drogueria.api.entities.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Integer>{

}
