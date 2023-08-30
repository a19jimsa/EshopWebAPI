package com.eshop.Eshop.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int quantity;
    private double price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order order;
    public Order getOrder() {
        return order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
