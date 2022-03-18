package com.drogueria.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    
    
    @JsonIgnoreProperties(value = {"producto", "hybernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Domicilio> domicilios;
    
    
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
	
	 public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
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
