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
import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.DomicilioException;
import com.drogueria.api.persistencia.ArchivoUtil;
import com.drogueria.api.services.DomicilioServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class DomicilioRestController {
	
	@Autowired
	private DomicilioServiceImpl domicilioServiceImpl;
	public static final String RUTA_ARCHIVO_LOG = "src/main/java/resources/DrogueriaLogDomicilio.txt";
	
	
	@GetMapping("/domicilios")
	public List<Domicilio> getDomicilios(){
		try {
			ArchivoUtil.guardarRegistroLog("Se muestran todos los domicilios", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return domicilioServiceImpl.findAll();
	}
	
//	@GetMapping("/domicilios/{id}")
//	public Domicilio getDomicilio(@PathVariable int id) {
//		return domicilioServiceImpl.findById(id);
//	}
	
	@GetMapping("/domicilios/{id}")
	public ResponseEntity<?> getClient(@PathVariable int id) {
		
		Map<String, Object> response= new HashMap<>();
		Domicilio domicilio=null;
		
		try {
			domicilio=domicilioServiceImpl.findById(id);
			ArchivoUtil.guardarRegistroLog("Se muestran el domicilio", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error de conexion en la base de datos");
			response.put("mensaje", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (domicilio==null) {
			response.put("mensaje", "El domicilio con ID: ".concat(""+id).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Domicilio> (domicilio, HttpStatus.OK);
	}
	
	
	@PostMapping("/domicilios")
	@ResponseStatus(HttpStatus.CREATED)
	public  ResponseEntity<String> createDomicilio(@RequestBody Domicilio domicilio) {
		
		
		try {
			domicilioServiceImpl.save(domicilio);
			System.out.println("Servicio de crear realizado");
			domicilio.toString();
			
			ArchivoUtil.guardarRegistroLog("Se creo un domicilio", 1, "PostMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/domicilios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDomicilio(@PathVariable int id) {
		try { 
			domicilioServiceImpl.delete(id);
			ArchivoUtil.guardarRegistroLog("Se elimino un domicilio", 1, "DeleteMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("/domicilios/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateDomicilio(@RequestBody Domicilio domicilio, @PathVariable int id) throws DomicilioException{
		try {
			domicilioServiceImpl.update(domicilio, id);
			ArchivoUtil.guardarRegistroLog("Se actualizo un domicilio", 1, "PutMapping", RUTA_ARCHIVO_LOG);
		} catch (DomicilioException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/domicilios/{costo1}/{costo2}")
	public List<Domicilio> consulta1(@PathVariable double costo1, @PathVariable double costo2) {
		return domicilioServiceImpl.consulta1Costo(costo1, costo2);
	}
	
//	@GetMapping("/domicilios/{direccion}")
//	public List<Domicilio> consulta2(@PathVariable String direccion) {
//		return domicilioServiceImpl.consulta2Direccion(direccion);
//	}
	

}
