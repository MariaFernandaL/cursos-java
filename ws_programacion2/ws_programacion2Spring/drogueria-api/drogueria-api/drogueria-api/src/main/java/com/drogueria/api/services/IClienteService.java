package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.exception.ClienteException;

public interface IClienteService {

	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Optional<Cliente> findById(int id);
	void update(Cliente cliente, int id) throws ClienteException;
	void delete(int id);
	
	
}
