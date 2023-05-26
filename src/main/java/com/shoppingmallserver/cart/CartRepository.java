package com.shoppingmallserver.cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {


    Cart findByMemberIdAndItemId(Long id, Long item);

    Page<Cart> findAllByMemberId(Long id, Pageable pageable);

}
