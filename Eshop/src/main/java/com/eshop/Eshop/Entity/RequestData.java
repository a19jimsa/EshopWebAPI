package com.eshop.Eshop.Entity;

import java.util.List;

public class RequestData {
    private Customer customer;
    private List<Product> productList;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
