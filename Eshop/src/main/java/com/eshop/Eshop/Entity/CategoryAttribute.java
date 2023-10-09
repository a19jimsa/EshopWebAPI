package com.eshop.Eshop.Entity;

import jakarta.persistence.*;

@Entity
public class CategoryAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    private String name;
    private String valueType;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getValue() {
        return valueType;
    }

    public void setValue(String value) {
        this.valueType = value;
    }
}
