package com.eshop.Eshop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String url;
    public Integer getId() {
        return Id;
    }
    public String getUrl() {
        return url;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
