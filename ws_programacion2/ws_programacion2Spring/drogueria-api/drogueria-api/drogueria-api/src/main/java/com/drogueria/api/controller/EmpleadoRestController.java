package com.drogueria.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.entities.Empleado;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.EmpleadoException;
import com.drogueria.api.persistencia.ArchivoUtil;
import com.drogueria.api.services.EmpleadoServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadoServiceImpl empleadoServiceImpl;
	
	
	public static final String RUTA_ARCHIVO_LOG = "src/main/java/resources/DrogueriaLogEmpleado.txt";
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados(){
		try {
			ArchivoUtil.guardarRegistroLog("Se muestran todos los empleados", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleadoServiceImpl.findAll();
	}
	
//	@GetMapping("/empleados/{id}")
//	public Empleado getEmpleado(@PathVariable int id) {
//		try {
//			ArchivoUtil.guardarRegistroLog("Se muestran todos los empleados", 1, "GetMapping", RUTA_ARCHIVO_LOG);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return empleadoServiceImpl.findById(id);
//	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> getEmpleado(@PathVariable int id) {
		
		Map<String, Object> response= new HashMap<>();
		Empleado empleado=null;
		
		try {
			empleado=empleadoServiceImpl.findById(id);
			ArchivoUtil.guardarRegistroLog("Se muestran el empleado", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error de conexion en la base de datos");
			response.put("mensaje", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (empleado==null) {
			response.put("mensaje", "El empleado con ID: ".concat(""+id).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Empleado> (empleado, HttpStatus.OK);
	}

	
	@PostMapping("/empleados")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmpleado(@RequestBody Empleado empleado) {
		System.out.println("Servicio de crear solicitado");
		empleadoServiceImpl.save(empleado);
	}

	@DeleteMapping("empleados/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmpleado(@PathVariable int id) {
		empleadoServiceImpl.delete(id);
	}
	
	@PutMapping("/empleados/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateEmpleado(@RequestBody Empleado empleado, @PathVariable int id) throws EmpleadoException{
		empleadoServiceImpl.update(empleado,id);
	}

}
