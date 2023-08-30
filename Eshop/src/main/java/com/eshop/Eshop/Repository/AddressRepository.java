package com.eshop.Eshop.Repository;


import com.eshop.Eshop.Entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    Address findCategoryById(Integer id);

}
