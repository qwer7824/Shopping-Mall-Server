package com.shoppingmallserver.cart;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String memberId;

    @Column
    private Long itemId;

    @ColumnDefault("0")
    private Integer count;
    
}