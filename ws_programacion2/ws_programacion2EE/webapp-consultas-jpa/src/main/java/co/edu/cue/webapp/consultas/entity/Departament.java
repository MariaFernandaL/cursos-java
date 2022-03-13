package co.edu.cue.webapp.consultas.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="departament")
public class Departament implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartament;

    private String departamentName;
    private int idEmployee;
    private int idLocation;

    public Departament() {
    }

    public int getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(int idDepartament) {
        this.idDepartament = idDepartament;
    }

    public String getDepartamentName() {
        return departamentName;
    }

    public void setDepartamentName(String departamentName) {
        this.departamentName = departamentName;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "idDepartament=" + idDepartament +
                ", departamentName='" + departamentName + '\'' +
                ", idEmployee=" + idEmployee +
                ", idLocation=" + idLocation +
                '}';
    }
}
