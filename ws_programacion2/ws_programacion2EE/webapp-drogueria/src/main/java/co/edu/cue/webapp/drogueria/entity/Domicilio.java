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


    @OneToMany(
            mappedBy = "domicilio"
    )
    private List<Cliente> clientes;
    @OneToMany(
            mappedBy = "domicilio"
    )
    private List<Empleado> empleados;
    @OneToMany(
            mappedBy = "domicilio"
    )
    private List<Producto> productos;


    public Domicilio() {
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
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
