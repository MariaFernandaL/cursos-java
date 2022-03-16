package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogueria.api.entities.Empleado;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.EmpleadoException;
import com.drogueria.api.repositories.IEmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

	@Autowired
	IEmpleadoRepository empleadoRepository;
	
	@Override
	@Transactional
	public List<Empleado> findAll() {
		return (List<Empleado>)empleadoRepository.findAll();
	}
	

	@Override
	@Transactional
	public void save(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	@Transactional
	public Optional<Empleado> findById(int id) {
		return empleadoRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Empleado empleado, int id) throws EmpleadoException{
		if (findById(id)==null) {
			throw new EmpleadoException("El empleado no existe");
		}
		empleadoRepository.save(empleado);
	}

	@Override
	@Transactional
	public void delete(int id) {
		empleadoRepository.deleteById(id);
	}

}
