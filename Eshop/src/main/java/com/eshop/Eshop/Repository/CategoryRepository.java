package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    Category findCategoryById(Integer id);

    List<Category> findByParentCategory(Category parentCategory);

    Category findCategoryByCategoryName(String name);

    Category findByParentCategoryAndCategoryName(Category category, String name);

}
