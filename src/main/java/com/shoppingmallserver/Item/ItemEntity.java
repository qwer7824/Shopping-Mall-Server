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

    public static ItemEntity of(String name, String imgPath, Integer price , String content){
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setImgPath(imgPath);
        item.setPrice(price);
        item.setContent(content);
        return item;

    }



}
