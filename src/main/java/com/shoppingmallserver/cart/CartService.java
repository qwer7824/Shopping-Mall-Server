package com.shoppingmallserver.cart;

import com.shoppingmallserver.Item.Item;
import com.shoppingmallserver.Item.ItemRepository;
import com.shoppingmallserver.Member.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final MemberRepository memberRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;


    @Transactional
    public void pushCartItem(Long itemId, String account, Integer count) {

        Member member = memberRepository.findByAccount(account).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        Cart cart = cartRepository.findByMemberIdAndItemId(member.getAccount(), itemId);

        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setMemberId(member.getAccount());
            newCart.setItemId(itemId);
            newCart.setCount(count);
            cartRepository.save(newCart);
        } else {
            Cart update = cart;
            update.setMemberId(member.getAccount());
            update.setItemId(itemId);
            update.setCount(count);
            cartRepository.save(update);
        }
    }

    public List<Item> getCartItems(String account) {

        Member member = memberRepository.findByAccount(account).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        List<Cart> carts = cartRepository.findByMemberId(member.getAccount());
        List<Long> itemIds = carts.stream().map(Cart::getItemId).toList();
        List<Item> items = itemRepository.findByIdIn(itemIds);
        return items;
    }

    public void removeCartItem(Long itemId, String account) {
        Member member = memberRepository.findByAccount(account).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        Cart cart = cartRepository.findByMemberIdAndItemId(member.getAccount(), itemId);

        cartRepository.delete(cart);
    }

}
