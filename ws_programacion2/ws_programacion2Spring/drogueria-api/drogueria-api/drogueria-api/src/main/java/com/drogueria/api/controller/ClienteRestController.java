package com.drogueria.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.drogueria.api.entities.Cliente;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.services.ClienteServiceImpl;

@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class ClienteRestController {
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteServiceImpl.findAll();
	}
	
//	@GetMapping("/clientes/{id}")
//	public Optional<Cliente> getClient(@PathVariable int id) {
//		return clienteServiceImpl.findById(id);
//	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> getClient(@PathVariable int id) {
		
		Map<String, Object> response= new HashMap<>();
		Cliente cliente=null;
		
		try {
			cliente=clienteServiceImpl.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error de conexion en la base de datos");
			response.put("mensaje", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (cliente==null) {
			response.put("mensaje", "El cliente con ID: ".concat(""+id).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Cliente> (cliente, HttpStatus.OK);
		
		
	}

	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public void createClient(@RequestBody Cliente cliente) {
		System.out.println("Servicio de crear solicitado");
		clienteServiceImpl.save(cliente);
	}

	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable int id) {
		clienteServiceImpl.delete(id);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateClient(@RequestBody Cliente cliente, @PathVariable int id) throws ClienteException{
		clienteServiceImpl.update(cliente,id);
	}
	
	/*
	private ArrayList<Cliente> getClientes() {
		ArrayList<Cliente> listaClientes= new ArrayList<>();
		
		Cliente cliente=new Cliente();
		cliente.setNombre("Maria");
		cliente.setCedula("1234");
		cliente.setDireccion("armenia");
		cliente.setCorreo("maria@gmail.com");
		cliente.setTelefono("7832649");
		listaClientes.add(cliente);
		cliente.setPago(10000.0);
		
		cliente=new Cliente();
		cliente.setNombre("Manuel");
		cliente.setCedula("4321");
		cliente.setDireccion("calarca");
		cliente.setCorreo("manuel@gmail.com");
		cliente.setTelefono("387580");
		cliente.setPago(20000.0);
		listaClientes.add(cliente);
		
		cliente=new Cliente();
		cliente.setNombre("David");
		cliente.setCedula("7890");
		cliente.setDireccion("calarca");
		cliente.setCorreo("david@gmail.com");
		cliente.setTelefono("79887498");
		cliente.setPago(30000.0);
		listaClientes.add(cliente);
		
		cliente=new Cliente();
		cliente.setNombre("Juan");
		cliente.setCedula("7584");
		cliente.setDireccion("cali");
		cliente.setCorreo("juan@gmail.com");
		cliente.setTelefono("80928373");
		cliente.setPago(3000.0);
		listaClientes.add(cliente);
		return listaClientes;
	}
		
	}*/
}
