package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    Image findImageById(Integer id);
}
