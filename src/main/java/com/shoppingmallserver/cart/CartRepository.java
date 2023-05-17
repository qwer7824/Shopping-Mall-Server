package com.shoppingmallserver.cart;

import com.shoppingmallserver.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByMemberId(String memberId);

    Cart findByMemberIdAndItemId(String memberId, Long itemId);

    void deleteByMemberId(Long memberId);

}
