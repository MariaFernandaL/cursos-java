package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.repositories.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteRepository clienteRepository;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteRepository.findAll();
	}
	

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Optional<Cliente> findById(int id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Cliente cliente, int id) {
		//cliente= clienteRepository.findById(id);
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(int id) {
		clienteRepository.deleteById(id);
	}
	


}
