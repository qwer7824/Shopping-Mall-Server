package com.shoppingmallserver.order;

import com.shoppingmallserver.Item.ItemEntity;
import com.shoppingmallserver.Item.ItemRepository;
import com.shoppingmallserver.Member.Member;
import com.shoppingmallserver.Member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public OrderResponse order(OrderDto orderDto, String account){

        ItemEntity item = itemRepository.findById(orderDto.getItemId())
                .orElseThrow(EntityNotFoundException::new);

        Member member = getUserEntityOrException(account);

        List<OrderItem> orderItemList = new ArrayList<>();
        OrderItem orderItem = OrderItem.createOrderItem(item, orderDto.getCount());
        orderItemList.add(orderItem);
        Order order = Order.createOrder(member, orderItemList);
        Order saved = orderRepository.save(order);

        return modelMapper.map(saved,OrderResponse.class);
    }


    public Member getUserEntityOrException(String account){
        return memberRepository.findByAccount(account).orElseThrow(() ->
                new BadCredentialsException(String.format("%s not founded", account)));
    }
}
