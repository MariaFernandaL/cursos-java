package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.DomicilioException;
import com.drogueria.api.repositories.IDomicilioRepository;

@Service
public class DomicilioServiceImpl implements IDomicilioService{

	@Autowired
	IDomicilioRepository domicilioRepository;
	
	@Override
	@Transactional
	public List<Domicilio> findAll() {
		return (List<Domicilio>)domicilioRepository.findAll();
	}
	

	@Override
	@Transactional
	public void save(Domicilio domicilio, int idCliente) {
		domicilioRepository.save(domicilio);
	}

	@Override
	@Transactional
	public Domicilio findById(int id) {
		return domicilioRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void update(Domicilio domicilio, int id) throws DomicilioException{
		if (findById(id)==null) {
			throw new DomicilioException("El domicilio no existe");
		}
		domicilioRepository.save(domicilio);
	}

	@Override
	@Transactional
	public void delete(int id) {
		domicilioRepository.deleteById(id);
	}

}
