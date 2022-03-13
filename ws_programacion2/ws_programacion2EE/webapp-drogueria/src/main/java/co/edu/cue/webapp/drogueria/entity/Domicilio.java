package co.edu.cue.webapp.drogueria.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDomicilio;

    private String codigo;

    //MINUTO 1:31:44 CLASE 18---> FORMATEAR FECHA DESDE EL MAIN AL CREAR DOMICILIO
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String direccion;
    private double costo;


    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Empleado empleado;



    public Domicilio() {
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


}
