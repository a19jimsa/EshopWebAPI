package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Category;
import com.eshop.Eshop.Entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findProductById(Integer id);

    Iterable<Product> findProductByCategoryCategoryName(String name);

    Collection<? extends Product> findByCategory(Category category);
}
