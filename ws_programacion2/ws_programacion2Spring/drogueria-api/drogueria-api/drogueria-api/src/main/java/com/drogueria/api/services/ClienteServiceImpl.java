package com.drogueria.api.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.repositories.IClienteRepository;
import com.drogueria.api.repositories.IDomicilioRepository;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteRepository clienteRepository;
	@Autowired
	IDomicilioRepository domicilioRepository;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {
		return (List<Cliente>)clienteRepository.findAll();
	}
	

	@Override
	@Transactional
	public void save(Cliente cliente) throws ClienteException{
		Cliente cliente2= null;
		cliente2=clienteRepository.findClienteByCedula(cliente.getCedula());
		
		if (cliente2!=null) {
			throw new ClienteException("El cliente ya esta registrado con esta cedula");
		}
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public Cliente findById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void update(Cliente cliente, int id) throws ClienteException{
		if (findById(id)==null) {
			throw new ClienteException("El cliente no existe");
		}
		clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(int id) throws ClienteException{
//		Domicilio domicilio= null;
//		domicilio=domicilioRepository.findClienteByIdEliminar(id);
//		
//		if (domicilio!=null) {
//			throw new ClienteException("El cliente no se puede eliminar");
//		}
		clienteRepository.deleteById(id);
	}
	


}
