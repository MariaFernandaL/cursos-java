package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Empleado;
import com.drogueria.api.exception.EmpleadoException;

public interface IEmpleadoService {

	public List<Empleado> findAll();
	public void save(Empleado empleado);
	public Empleado findById(int id);
	void update(Empleado empleado, int id) throws EmpleadoException;
	void delete(int id);
	
}
