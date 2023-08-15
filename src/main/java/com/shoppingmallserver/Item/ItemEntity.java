package com.shoppingmallserver.Item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"item\"")
public class ItemEntity {
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

    public static ItemEntity fromEntity(ItemEntity entity){ //Entity -> DTO
        return new ItemEntity(
                entity.getId(),
                entity.getName(),
                entity.getImgPath(),
                entity.getPrice(),
                entity.getContent()
        );
    }


}
