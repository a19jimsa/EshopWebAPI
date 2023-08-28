package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product findProductById(Integer id);
}
