package com.drogueria.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDomicilio;

    private String codigo;
    private Date fecha;
    private String direccion;
    private Double costo;
    
    @JsonIgnoreProperties(value= {"domicilios",  "hibernateLazyInitializer", "handler"}, allowSetters = false)
    @ManyToOne(fetch = FetchType.LAZY)   
    private Cliente cliente;
    
    @JsonIgnoreProperties(value= {"domicilios",  "hibernateLazyInitializer", "handler"}, allowSetters = false)
    @ManyToOne(fetch = FetchType.LAZY)   
    private Empleado empleado;
    
    
    @JsonIgnoreProperties(value= {"domicilios",  "hibernateLazyInitializer", "handler"}, allowSetters = false)
    @ManyToOne(fetch = FetchType.LAZY)   
    private Producto producto;

	public Domicilio() {
		
	}
 
	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio  +
                ", codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", costo='" + costo + '\'' +
                '}';
    }
    
    
}
