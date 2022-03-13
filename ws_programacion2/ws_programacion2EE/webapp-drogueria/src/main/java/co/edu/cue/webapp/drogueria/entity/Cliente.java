package co.edu.cue.webapp.drogueria.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;


    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String correo;
    private Double pago;

    @OneToMany(mappedBy="cliente")
    private List<Domicilio> domicilios;

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }



    public Cliente(){

    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getPago() {
        return pago;
    }

    public void setPago(Double pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", pago='" + pago + '\'' +
                '}';
    }
}
