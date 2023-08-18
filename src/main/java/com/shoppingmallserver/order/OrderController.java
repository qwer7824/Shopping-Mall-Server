package com.shoppingmallserver.order;

import com.shoppingmallserver.Member.MemberRepository;
import com.shoppingmallserver.Member.SignRequest;
import com.shoppingmallserver.Member.SignResponse;
import com.shoppingmallserver.Member.SignService;
import com.shoppingmallserver.cart.Cart;
import com.shoppingmallserver.cart.CartRepository;
import com.shoppingmallserver.cart.CartService;
import com.shoppingmallserver.config.ResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static com.shoppingmallserver.config.ResponseDTO.ok;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final MemberRepository memberRepository;
    private final SignService memberService;
    private final CartService cartService;
    private final CartRepository cartRepository;
    private final OrderService orderService;


    @PostMapping(value = "/user/order")
    public ResponseDTO<OrderResponse> order(@RequestBody @Valid OrderDto orderDto
            , Principal principal){
        return ok(orderService.order(orderDto, principal.getName()));
    }
}
