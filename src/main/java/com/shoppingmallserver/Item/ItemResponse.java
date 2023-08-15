package com.shoppingmallserver.Item;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ItemResponse {

    private Long id;

    private String name;

    private String imgPath;

    private int price;

    private String content;

}
