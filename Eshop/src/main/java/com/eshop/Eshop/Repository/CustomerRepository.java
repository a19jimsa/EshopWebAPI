package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    boolean existsByEmail(String email);
    Customer findCustomerById(Integer id);
}
