package com.shoppingmallserver.Item;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class ItemRequest {

    private String name;

    private String imgPath;

    private int price;

    private String content;

}
