package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findCategoryById(Integer id);

}
