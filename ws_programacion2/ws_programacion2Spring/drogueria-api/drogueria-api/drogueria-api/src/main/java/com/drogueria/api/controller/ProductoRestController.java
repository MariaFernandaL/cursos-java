package com.drogueria.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.ClientAbortException;
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
import com.drogueria.api.entities.Producto;
import com.drogueria.api.exception.ClienteException;
import com.drogueria.api.exception.ProductoException;
import com.drogueria.api.persistencia.ArchivoUtil;
import com.drogueria.api.services.ClienteServiceImpl;
import com.drogueria.api.services.ProductoServiceImpl;


@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class ProductoRestController {

	@Autowired
	private ProductoServiceImpl productoServiceImpl;
	public static final String RUTA_ARCHIVO_LOG = "src/main/java/resources/DrogueriaLogProducto.txt";
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		try {
			ArchivoUtil.guardarRegistroLog("Se muestran todos los productos", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productoServiceImpl.findAll();
	}
	
//	@GetMapping("/productos/{id}")
//	public Producto getProducto(@PathVariable int id) {
//		return productoServiceImpl.findById(id);
//	}
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> getClient(@PathVariable int id) {
		
		Map<String, Object> response= new HashMap<>();
		Producto producto=null;
		
		try {
			producto=productoServiceImpl.findById(id);
			ArchivoUtil.guardarRegistroLog("Se muestra el producto", 1, "GetMapping", RUTA_ARCHIVO_LOG);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error de conexion en la base de datos");
			response.put("mensaje", e.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (producto==null) {
			response.put("mensaje", "El producto con ID: ".concat(""+id).concat(" no existe en la base de datos"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto> (producto, HttpStatus.OK);
	}
	
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProducto(@RequestBody Producto producto) {
		System.out.println("Servicio de crear solicitado");
		try {
			productoServiceImpl.save(producto);
			ArchivoUtil.guardarRegistroLog("Se creo un producto", 1, "PostMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DeleteMapping("productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProducto(@PathVariable int id) {
		try {
			productoServiceImpl.delete(id);
			ArchivoUtil.guardarRegistroLog("Se elimino un producto", 1, "DeleteMapping", RUTA_ARCHIVO_LOG);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping("productos/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateProducto(@RequestBody Producto producto, @PathVariable int id) throws ProductoException{
		try {
			ArchivoUtil.guardarRegistroLog("Se actualizo un cliente", 1, "PutMapping", RUTA_ARCHIVO_LOG);
			productoServiceImpl.update(producto,id);
		} catch (ProductoException e) {
			e.printStackTrace();
		}
	}

}
