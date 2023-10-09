package com.eshop.Eshop.Entity;

import jakarta.persistence.*;

@Entity(name = "order_products")
public class OrderItem {
    @EmbeddedId
    private OrderItemId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    public OrderItemId getId() {
        return id;
    }

    public void setId(OrderItemId id) {
        this.id = id;
    }

    public OrderItem(){

    }
    public OrderItem(Order order, Product product){
        this.id = new OrderItemId(order.getId(), product.getId());
        this.order = order;
        this.product = product;
    }

    public OrderItemId getOrderItemId() {
        return id;
    }
    public void setOrderItemId(OrderItemId orderItemId) {
        this.id = orderItemId;
    }
    public Product getProduct() {
        return product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
