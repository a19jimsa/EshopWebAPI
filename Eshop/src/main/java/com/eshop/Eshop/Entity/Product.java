package com.eshop.Eshop.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int inventory_amount;

    @ManyToOne
    private Category category;

    @OneToMany
    private Set<Image> images = new HashSet<>();

    //Setter and getters
    public Set<Image> getImages() {
        return images;
    }
    public void setImages(Set<Image> images) {
        this.images = images;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public int getInventory_amount() {
        return inventory_amount;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInventory_amount(int inventory_amount) {
        this.inventory_amount = inventory_amount;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
