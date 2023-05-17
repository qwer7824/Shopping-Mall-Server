package com.shoppingmallserver.cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("/user/cart/items/{itemId}")
    public ResponseEntity pushCartItem(
            @PathVariable("itemId") Long itemId,
            Principal principal) {
        log.info("{}",principal.getName());
        cartService.pushCartItem(itemId, principal.getName());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/cart/items")
    public ResponseEntity getCartItems(Principal principal) {
        cartService.getCartItems(principal.getName());
        log.info("{}",principal.getName());
        return ResponseEntity.ok().body(cartService.getCartItems(principal.getName()).stream().toList());
    }

}
