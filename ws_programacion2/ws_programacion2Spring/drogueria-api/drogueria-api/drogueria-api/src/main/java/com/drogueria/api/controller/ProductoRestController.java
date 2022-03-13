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

import com.drogueria.api.entities.Producto;
import com.drogueria.api.services.ProductoServiceImpl;


//@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
@RequestMapping("/api/drogueria")
public class ProductoRestController {

	@Autowired
	private ProductoServiceImpl productoServiceImpl;
	
	
	@GetMapping("/productos")
	public List<Producto> getProductos(){
		return productoServiceImpl.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Optional<Producto> getProducto(@PathVariable int id) {
		return productoServiceImpl.findById(id);
	}
	
	
	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProducto(@RequestBody Producto producto) {
		System.out.println("Servicio de crear solicitado");
		productoServiceImpl.save(producto);
	}
	
	@DeleteMapping("productos/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProducto(@PathVariable int id) {
		productoServiceImpl.delete(id);
	}
	
	//@PutMapping("productos/update/{id}")
	//@ResponseStatus(HttpStatus.ACCEPTED)
	//public void updateProducto(@RequestBody Producto producto, @PathVariable int id) {
	
	//}

}
