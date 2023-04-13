package com.shoppingmallserver.Item;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    public Item itemView(Long id) {
        return itemRepository.findById(id).get();
    }


    public List<Item> allItemView() {
        return itemRepository.findAll();
    }

    public Item getProductDetails(Long id) {

        return itemRepository.findById(id).get();
    }

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