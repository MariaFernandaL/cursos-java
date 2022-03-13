package co.edu.cue.webapp.consultas.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="location")
public class Location implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocation;


    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private int Countrie_idCountrie;

    public Location() {
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public int getIdCountry() {
        return Countrie_idCountrie;
    }

    public void setIdCountry(int Countrie_idCountrie) {
        this.Countrie_idCountrie = Countrie_idCountrie;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", idCountry=" + Countrie_idCountrie +
                '}';
    }
}
