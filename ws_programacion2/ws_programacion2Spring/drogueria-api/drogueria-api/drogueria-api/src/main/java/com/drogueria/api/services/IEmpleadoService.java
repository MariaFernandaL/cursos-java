package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	public void save(Empleado empleado);
	public Optional<Empleado> findById(int id);
	void update(Empleado empleado, int id);
	void delete(int id);
	
}
