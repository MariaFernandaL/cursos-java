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
import com.drogueria.api.entities.Domicilio;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.DomicilioException;
import com.drogueria.api.persistencia.ArchivoUtil;
import com.drogueria.api.services.ClienteServiceImpl;

@CrossOrigin(origins = {"http://localhost:8080" })
@RestController
@RequestMapping("/api/drogueria")
public class ClienteRestController {
	
	@Autowired
	private ClienteServiceImpl clienteServiceImpl;
	
	
	public static final String RUTA_ARCHIVO_LOG = "src/main/java/resources/DrogueriaLogCliente.txt";
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		try {
			ArchivoUtil.guardarRegistroLog("Se muestran todos los clientes", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clienteServiceImpl.findAll();
	}
	
	
//	@GetMapping("/clientes/{id}")
//	public Cliente getClient(@PathVariable int id) {
//		return clienteServiceImpl.findById(id);
//	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> getClient(@PathVariable int id) {
		
		Map<String, Object> response= new HashMap<>();
		Cliente cliente=null;
		
		try {
			cliente=clienteServiceImpl.findById(id);
			ArchivoUtil.guardarRegistroLog("Se muestran el cliente", 1, "GetMapping", RUTA_ARCHIVO_LOG);
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
	public ResponseEntity<String> createClient(@RequestBody Cliente cliente){
		System.out.println("Servicio de crear solicitado");
		try {
			clienteServiceImpl.save(cliente);
			ArchivoUtil.guardarRegistroLog("Se creo un cliente", 1, "PostMapping", RUTA_ARCHIVO_LOG);
		} catch (ClienteException e) {
			e.printStackTrace();
			return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("",HttpStatus.CREATED);
	}

	
	
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> deleteClient(@PathVariable int id) {
		try {
			clienteServiceImpl.delete(id);
			ArchivoUtil.guardarRegistroLog("Se elimino un cliente", 1, "DeleteMapping", RUTA_ARCHIVO_LOG);
		} catch (ClienteException e) {
			e.printStackTrace();
			return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateDomicilio(@RequestBody Cliente cliente, @PathVariable int id) throws ClienteException{
		try {
			clienteServiceImpl.update(cliente, id);
			ArchivoUtil.guardarRegistroLog("Se actualizo un cliente", 1, "PutMapping", RUTA_ARCHIVO_LOG);
		} catch (ClienteException e) {
			e.printStackTrace();
		}
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
