package co.edu.cue.webapp.consultas.entity;


import jakarta.persistence.*;

import java.io.Serializable;

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



    public Cliente(){

    }

    public Cliente(String nombre, String direccion){
        this.nombre= nombre;
        this.direccion=direccion;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    public String listarClientes(){
        return "Cliente{" +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
