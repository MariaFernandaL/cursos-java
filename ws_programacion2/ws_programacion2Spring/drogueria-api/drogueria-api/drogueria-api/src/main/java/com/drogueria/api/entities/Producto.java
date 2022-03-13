package com.drogueria.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    
    
    private String nombre;
    private String codigo;
    private Double valorUnidad;
    private int cantidad;
    
    public Producto() {
    	
    }

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(Double valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	 @Override
	    public String toString() {
	        return "Producto{" +
	                "idProducto=" + idProducto +
	                ", nombre='" + nombre + '\'' +
	                ", codigo='" + codigo + '\'' +
	                ", valorUnidad='" + valorUnidad + '\'' +
	                ", cantidad='" + cantidad + '\'' +
	                '}';
	    }
    
    
    
}
