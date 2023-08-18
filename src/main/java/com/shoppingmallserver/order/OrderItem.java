package com.shoppingmallserver.order;

import com.fasterxml.classmate.AnnotationOverrides;
import com.shoppingmallserver.Item.ItemEntity;
import com.shoppingmallserver.Member.Member;
import com.shoppingmallserver.cart.Cart;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; //주문가격

    private int count; //수량

    public static OrderItem createOrderItem(ItemEntity item, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setOrderPrice(item.getPrice());
        return orderItem;
    }

    public int getTotalPrice(){
        return orderPrice*count;
    }

}
