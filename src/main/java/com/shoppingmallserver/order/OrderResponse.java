package com.shoppingmallserver.order;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class OrderResponse {
    private Long itemId;
    private int count;
}
