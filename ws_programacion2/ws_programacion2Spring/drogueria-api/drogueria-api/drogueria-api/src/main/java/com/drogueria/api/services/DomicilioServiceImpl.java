package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Domicilio;
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
	public void save(Domicilio domicilio) {
		domicilioRepository.save(domicilio);
	}

	@Override
	@Transactional
	public Optional<Domicilio> findById(int id) {
		return domicilioRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Domicilio domicilio, int id) {
		//domicilio= domicilioRepository.findById(id);
		domicilioRepository.save(domicilio);
	}

	@Override
	@Transactional
	public void delete(int id) {
		domicilioRepository.deleteById(id);
	}

}
