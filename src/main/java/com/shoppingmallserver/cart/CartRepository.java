package com.shoppingmallserver.cart;

import com.shoppingmallserver.Item.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {


    void deleteByMemberId(String memberId);

    Cart findByMemberIdAndItemId(Long id, Long item);

    Page<Cart> findAllByMemberId(Long id, Pageable pageable);
}
