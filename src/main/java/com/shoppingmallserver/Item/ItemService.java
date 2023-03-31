package com.shoppingmallserver.Item;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public String additem(ItemRequest request) {
        itemRepository.save(Item.builder()
                .name(request.getName())
                .imgPath(request.getImgPath())
                .price(request.getPrice())
                .content(request.getContent())
                .build());

        return "상품이 추가되었습니다.";
    }
}