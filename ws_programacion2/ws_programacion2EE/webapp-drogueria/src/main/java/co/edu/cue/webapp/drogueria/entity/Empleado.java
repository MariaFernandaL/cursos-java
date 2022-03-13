package co.edu.cue.webapp.drogueria.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private double salario;


    @OneToMany(mappedBy="empleado")
    private List<Domicilio> domicilios;

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }


    public Empleado() {

    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
