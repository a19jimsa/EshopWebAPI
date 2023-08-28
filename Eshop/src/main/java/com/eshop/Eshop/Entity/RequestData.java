package com.eshop.Eshop.Entity;

public class RequestData {
    private Product product;
    private Image image;

    private Category category;

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Image getImage() {
        return image;
    }

    public Product getProduct() {
        return product;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
