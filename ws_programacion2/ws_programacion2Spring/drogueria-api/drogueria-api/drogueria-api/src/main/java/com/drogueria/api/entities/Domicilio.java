package com.drogueria.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDomicilio;
    
    private int cliente_idcliente;
    private int producto_idproducto;
    private int empleado_idempleado;
    private String codigo;
    private Date fecha;
    private String direccion;
    private Double costo;
    
    public Domicilio() {
		
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public int getCliente_idcliente() {
		return cliente_idcliente;
	}

	public void setCliente_idcliente(int cliente_idcliente) {
		this.cliente_idcliente = cliente_idcliente;
	}

	public int getProducto_idproducto() {
		return producto_idproducto;
	}

	public void setProducto_idproducto(int producto_idproducto) {
		this.producto_idproducto = producto_idproducto;
	}

	public int getEmpleado_idempleado() {
		return empleado_idempleado;
	}

	public void setEmpleado_idempleado(int empleado_idempleado) {
		this.empleado_idempleado = empleado_idempleado;
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

	@Override
    public String toString() {
        return "Domicilio{" +
                "idDomicilio=" + idDomicilio  +
                ", cliente='" + cliente_idcliente + '\'' +
                ", producto='" + producto_idproducto + '\'' +
                ", empleado='" + empleado_idempleado + '\'' +
                ", codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", costo='" + costo + '\'' +
                '}';
    }
    
    
}
