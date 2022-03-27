package com.drogueria.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.entities.Domicilio;

public interface IDomicilioRepository extends CrudRepository<Domicilio, Integer>{

	
	@Query("SELECT d FROM Domicilio d WHERE d.codigo= :codigo")
	Domicilio findDomicilioByCodigo(
			@Param ("codigo") String codigo);
	
	@Query("SELECT d FROM Domicilio d WHERE d.cliente= :cliente")
	Domicilio findClienteByIdEliminar(
			@Param ("cliente") Cliente cliente);
	
	
	@Query("SELECT d FROM Domicilio d WHERE d.costo BETWEEN :costo1 AND :costo2")
	List<Domicilio> findDomicilioByCosto(
			@Param ("costo1") double costo1,@Param ("costo2") double costo2);
	
	@Query("SELECT d FROM Domicilio d WHERE "+
	"LOWER(d.direccion) LIKE LOWER(CONCAT('%',:direccion, '%'))")
	List<Domicilio> findDomicilioByDireccion(
			@Param ("direccion") String direccion);
}
