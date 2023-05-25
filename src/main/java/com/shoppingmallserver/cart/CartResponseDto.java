package com.shoppingmallserver.cart;

import com.shoppingmallserver.Item.Item;
import com.shoppingmallserver.Member.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
    private int cartId;
    private Long memberId;
    private Item item;
    private Integer count;
    private LocalDate createDate;


    public static CartResponseDto toDto(final Cart cart) {
        return CartResponseDto.builder()
                .cartId(cart.getCartId())
                .memberId(cart.getMember().getId())
                .item(Item.fromEntity(cart.getItem()))
                .count(cart.getCount())
                .createDate(cart.getCreateDate())
                .build();

    }

}
