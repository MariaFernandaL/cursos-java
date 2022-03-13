package co.edu.cue.webapp.consultas.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="region")
public class Region implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRegion;

    private String regionName;

    public Region() {
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "idRegion=" + idRegion +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
