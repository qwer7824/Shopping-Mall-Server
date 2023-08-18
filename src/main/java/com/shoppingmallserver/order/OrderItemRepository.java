package com.shoppingmallserver.order;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}