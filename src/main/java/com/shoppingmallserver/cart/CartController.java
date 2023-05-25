package com.shoppingmallserver.cart;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;
    private final CartRepository cartRepository;

    @PostMapping("/user/cart/items/{itemId}")
    public ResponseEntity pushCartItem(
            @PathVariable("itemId") Long itemId,
            Principal principal, @RequestBody CartRequest request) {
        log.info("{}",principal.getName());
        cartService.pushCartItem(itemId, principal.getName(),request.getCount());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/cart/items")
    public ResponseEntity getCartItems(Principal principal,Pageable pageable){
        log.info("{}",principal.getName());
        return ResponseEntity.ok().body(cartService.getCartItems(principal.getName(),pageable));
    }

    @GetMapping("/user/cart/item")
    public ResponseEntity getCartItem(Principal principal) {
        log.info("{}",principal.getName());
        return ResponseEntity.ok().body(cartRepository.findAll());
    }


}
