package com.shoppingmallserver.Item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    public ItemResponse(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.imgPath = item.getImgPath();
        this.price = item.getPrice();
        this.content = item.getContent();
    }

    private Long id;

    private String name;

    private String imgPath;

    private int price;

    private String content;

}
