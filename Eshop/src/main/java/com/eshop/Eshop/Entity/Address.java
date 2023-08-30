package com.eshop.Eshop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String streetname;
    private String zipcode;
    private String city;
    private String state;

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getStreetname() {
        return streetname;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
