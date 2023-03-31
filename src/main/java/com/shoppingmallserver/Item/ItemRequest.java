package com.shoppingmallserver.Item;

import lombok.*;

@Getter
@Setter
public class ItemRequest {


    private Long id;

    private String name;

    private String imgPath;

    private int price;

    private String Content;

}
