package com.drogueria.api.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.entities.Domicilio;

public interface IDomicilioRepository extends CrudRepository<Domicilio, Integer>{

	
	@Query("SELECT d FROM Domicilio d WHERE d.codigo= :codigo")
	Domicilio findDomicilioByCodigo(
			@Param ("codigo") String codigo);
	
//	@Query("SELECT d FROM Domicilio d WHERE d.cliente= :idcliente")
//	Domicilio findClienteByIdEliminar(
//			@Param ("idcliente") int idcliente);
	
	
	
}
