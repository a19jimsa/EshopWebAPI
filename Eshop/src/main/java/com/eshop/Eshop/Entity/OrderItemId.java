package com.eshop.Eshop.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class OrderItemId implements Serializable {
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "product_id")
    private Integer productId;

    public OrderItemId(){

    }

    public OrderItemId(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
