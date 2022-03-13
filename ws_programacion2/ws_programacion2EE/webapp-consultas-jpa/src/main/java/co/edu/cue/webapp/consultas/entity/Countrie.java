package co.edu.cue.webapp.consultas.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="countrie")
public class Countrie implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCountrie;

    private String countryName;
    private int Region_idRegion;

    public Countrie() {
    }

    public int getIdCountrie() {
        return idCountrie;
    }

    public void setIdCountrie(int idCountrie) {
        this.idCountrie = idCountrie;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegion_idRegion() {
        return Region_idRegion;
    }

    public void setRegion_idRegion(int region_idRegion) {
        Region_idRegion = region_idRegion;
    }

    @Override
    public String toString() {
        return "Countrie{" +
                "idCountrie=" + idCountrie +
                ", countryName='" + countryName + '\'' +
                ", Region_idRegion=" + Region_idRegion +
                '}';
    }
}
