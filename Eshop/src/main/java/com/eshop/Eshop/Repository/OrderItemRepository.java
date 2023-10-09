package com.eshop.Eshop.Repository;

import com.eshop.Eshop.Entity.OrderItem;
import com.eshop.Eshop.Entity.OrderItemId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, OrderItemId> {
}
