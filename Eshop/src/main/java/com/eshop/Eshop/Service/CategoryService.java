package com.eshop.Eshop.Service;

import com.eshop.Eshop.Entity.Category;
import com.eshop.Eshop.Entity.Product;
import com.eshop.Eshop.Repository.CategoryRepository;
import com.eshop.Eshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getAllSubcategories(Integer categoryId){
        List<Product> products = new ArrayList<>();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            products.addAll(productRepository.findByCategory(category));
            List<Category> subcategories = categoryRepository.findByParentCategory(category);
            for (Category subcategory : subcategories) {
                products.addAll(getAllSubcategories(subcategory.getId()));
            }
        }
        return products;
    }

    public List<Category> getParentCategories(String categoryName){
        List<Category> parentCategories = new ArrayList<>();
        Category currentCategory = categoryRepository.findCategoryByCategoryName(categoryName);
        while(currentCategory != null){
            parentCategories.add(currentCategory);
            currentCategory = currentCategory.getParentCategory();
        }
        Collections.reverse(parentCategories);
        return parentCategories;
    }

    public Category getAllParentCategories(String categoryName){
        List<String> strings = Arrays.asList(categoryName.split("-"));
        Category currentCategory = categoryRepository.findCategoryByCategoryName(strings.get(0));
        for(int i = 1; i < strings.size(); i++){
            String name = strings.get(i);
            Category subCategory = categoryRepository.findByParentCategoryAndCategoryName(currentCategory, name);
            if(subCategory == null){

            }
            currentCategory = subCategory;
        }
        return currentCategory;
    }
}
