package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Order findOrderById(Integer id);
}
