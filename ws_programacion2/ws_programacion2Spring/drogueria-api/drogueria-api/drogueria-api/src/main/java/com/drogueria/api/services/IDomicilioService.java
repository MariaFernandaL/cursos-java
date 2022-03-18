package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.DomicilioException;

public interface IDomicilioService {

	public List<Domicilio> findAll();
	public void save(Domicilio domicilio, int idCliente);//idEmpleado, idProducto
	public Domicilio findById(int id);
	void update(Domicilio domicilio, int id) throws DomicilioException;
	void delete(int id) throws DomicilioException;
}
