package com.shoppingmallserver.cart;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {

    private Integer count;



}