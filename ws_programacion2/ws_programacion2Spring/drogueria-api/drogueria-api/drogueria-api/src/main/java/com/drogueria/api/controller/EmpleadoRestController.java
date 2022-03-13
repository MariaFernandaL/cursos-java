package com.drogueria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.drogueria.api.entities.Empleado;
import com.drogueria.api.services.EmpleadoServiceImpl;

//@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		return empleadoServiceImpl.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public Optional<Empleado> getEmpleado(@PathVariable int id) {
		return empleadoServiceImpl.findById(id);
	}

	
	@PostMapping("/empleado")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmpleado(@RequestBody Empleado empleado) {
		System.out.println("Servicio de crear solicitado");
		empleadoServiceImpl.save(empleado);
	}

	@DeleteMapping("empleados/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmpleado(@PathVariable int id) {
		empleadoServiceImpl.delete(id);
	}
	
//	@PutMapping("empleados/update/{id}")
//	@ResponseStatus(HttpStatus.ACCEPTED)
//	public void updateEmpleado(@RequestBody Empleado empleado, @PathVariable int id) {
//		
//	}

}
