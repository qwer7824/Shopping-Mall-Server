package com.shoppingmallserver.cart;

import com.shoppingmallserver.Item.ItemEntity;
import com.shoppingmallserver.Item.ItemRepository;
import com.shoppingmallserver.Member.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final MemberRepository memberRepository;

    private final CartRepository cartRepository;

    private final ItemRepository itemRepository;



    public void pushCartItem(Long itemId, String account, Integer count) {

        Member member = getUserEntityOrException(account); // 유저찾기

        ItemEntity item = itemRepository.findItemById(itemId); // 아이템 찾기


        Cart cart = cartRepository.findByMemberIdAndItemId(member.getId(),item.getId());

        log.info(String.valueOf(cart));

        if(cart == null){
            cartRepository.save(Cart.builder()
                    .member(member)
                    .item(item)
                    .count(count)
                    .build());
        }else {
            Cart update = cart;
            update.setMember(cart.getMember());
            update.setItem(cart.getItem());
            update.setCount(count);
            cartRepository.save(update);

        }

        }



    public Page<CartResponseDto> getCartItems(String account, Pageable pageable) {
        Member member = getUserEntityOrException(account); // 유저찾기

        return cartRepository.findAllByMemberId(member.getId(),pageable).map(CartResponseDto::toDto);
    }

    public void deleteCart(String account,Integer cartId) {
        Member member = getUserEntityOrException(account); // 유저찾기

        Cart cart = cartRepository.findById(cartId).orElseThrow(() ->
                new BadCredentialsException("잘못된 카트 입니다."));

        if(member.getId() == cart.getMember().getId()) {
            cartRepository.delete(cart);
        }
    }


    public Member getUserEntityOrException(String account){
        return memberRepository.findByAccount(account).orElseThrow(() ->
                new BadCredentialsException(String.format("%s not founded", account)));
    }


}
