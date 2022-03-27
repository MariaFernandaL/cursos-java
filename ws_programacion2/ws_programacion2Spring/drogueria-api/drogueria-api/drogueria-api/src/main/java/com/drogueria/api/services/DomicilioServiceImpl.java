package com.drogueria.api.services;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Cliente;
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
	public void save(Domicilio domicilio) throws DomicilioException{
		Domicilio domicilio2= null;
		domicilio2=domicilioRepository.findDomicilioByCodigo(domicilio.getCodigo());
		
		if (domicilio2!=null) {
			throw new DomicilioException("El domicilo ya esta registrado con este codigo");
		}
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
	
	@Override
	@Transactional
	public List<Domicilio> consulta1Costo(double costo1, double costo2) {
		List<Domicilio> domicilios= domicilioRepository.findDomicilioByCosto(costo1, costo2);
		for(Domicilio domicilio: domicilios) {
			System.out.print(domicilio.toString());
		}
		return domicilios;
	}
	
	@Override
	@Transactional
	public List<Domicilio> consulta2Direccion(String direccion) {
		List<Domicilio> domicilios= domicilioRepository.findDomicilioByDireccion(direccion);
		for(Domicilio domicilio: domicilios) {
			System.out.print(domicilio.toString());
		}
		return domicilios;
	}

}
