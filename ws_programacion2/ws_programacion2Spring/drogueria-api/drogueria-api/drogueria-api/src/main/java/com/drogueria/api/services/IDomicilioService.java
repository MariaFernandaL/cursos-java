package com.drogueria.api.services;

import java.util.List;
import java.util.Optional;

import com.drogueria.api.entities.Domicilio;

public interface IDomicilioService {

	
	public List<Domicilio> findAll();
	public void save(Domicilio domicilio);
	public Optional<Domicilio> findById(int id);
	void update(Domicilio domicilio, int id);
	void delete(int id);
}
