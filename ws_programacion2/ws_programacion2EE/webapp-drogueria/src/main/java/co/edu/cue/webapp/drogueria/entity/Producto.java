package co.edu.cue.webapp.drogueria.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="producto")
public class Producto implements Serializable {
        private static final long serialVersionUID= 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idProducto;

        private String nombre;
        private String codigo;
        private double valorUnidad;
        private int cantidad;


    @OneToMany(mappedBy="producto")
    private List<Domicilio> domicilios;

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

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

    public double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(double valorUnidad) {
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
                ", valorUnidad=" + valorUnidad +
                ", cantidad=" + cantidad +
                '}';
    }
}
