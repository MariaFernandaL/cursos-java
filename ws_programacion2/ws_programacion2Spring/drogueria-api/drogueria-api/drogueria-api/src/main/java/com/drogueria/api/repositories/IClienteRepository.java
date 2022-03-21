package com.drogueria.api.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.entities.Domicilio;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

	@Query("SELECT c FROM Cliente c WHERE c.cedula= :cedula")
	Cliente findClienteByCedula(
			@Param ("cedula") String cedula);
	
}
