package com.eshop.Eshop.Entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @ManyToOne
    private Category category;
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;
    @OneToMany
    private List<Image> images = new ArrayList<>();
    //Setter and getters
    public List<Image> getImages() {
        return images;
    }
    public void setImages(List<Image> images) {
        this.images = images;
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
        return stock;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInventory_amount(int stock) {
        this.stock = stock;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCategory( Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }
}
