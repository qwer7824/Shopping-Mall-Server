package com.shoppingmallserver.order;

import com.shoppingmallserver.Member.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

}