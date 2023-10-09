package com.eshop.Eshop.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    private String categoryDescription;
    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;
    @OneToMany
    private List<Product> products;

    @OneToMany
    private List<CategoryAttribute> categoryAttributes;
    public Category() {
    }
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Integer getId() {
        return id;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
