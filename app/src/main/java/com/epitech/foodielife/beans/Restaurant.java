package com.epitech.foodielife.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Vincent RAGOT
 */
@Entity
@Table(name = "Restaurant")
public class Restaurant implements Serializable {

    @Id
    @Column(name = "idRestaurant", unique = true)
    private int idRestaurant;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    /**
     * Constructor
     */
    public Restaurant() {
    }

    /**
     * @return the idRestaurant
     */
    public int getIdRestaurant() {
        return idRestaurant;
    }

    /**
     * @param idRestaurant the idRestaurant to set
     */
    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the lattitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param lattitude the lattitude to set
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

}
