package com.shoppingmallserver.Item;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String imgPath;

    @Column
    private int price;

    @Column
    private String content;

    public static Item fromEntity(ItemEntity entity){ //Entity -> DTO
        return new Item(
                entity.getId(),
                entity.getName(),
                entity.getImgPath(),
                entity.getPrice(),
                entity.getContent()
        );
    }



}
