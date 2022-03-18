package com.drogueria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.DomicilioException;
import com.drogueria.api.services.DomicilioServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class DomicilioRestController {
	
	@Autowired
	private DomicilioServiceImpl domicilioServiceImpl;
	
	
	@GetMapping("/domicilios")
	public List<Domicilio> getDomicilios(){
		return domicilioServiceImpl.findAll();
	}
	
	@GetMapping("/domicilios/{id}")
	public Domicilio getDomicilio(@PathVariable int id) {
		return domicilioServiceImpl.findById(id);
	}
	
	
	@PostMapping("/domicilios")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDomicilio(@RequestBody Domicilio domicilio) {
		System.out.println("Servicio de crear solicitado");
		//domicilioServiceImpl.save(domicilio);
	}
	
	@DeleteMapping("/domicilios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDomicilio(@PathVariable int id) {
		domicilioServiceImpl.delete(id);
	}
	
	@PutMapping("/domicilios/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateDomicilio(@RequestBody Domicilio domicilio, @PathVariable int id) throws DomicilioException{
		domicilioServiceImpl.update(domicilio, id);
	}

}
