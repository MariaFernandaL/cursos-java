package com.drogueria.api.repositories;


import org.springframework.data.repository.CrudRepository;

import com.drogueria.api.entities.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

	
}
