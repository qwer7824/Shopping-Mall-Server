package com.shoppingmallserver.Item;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String imgPath;

    @Column
    private int price;

    @Column
    private String Content;
}
