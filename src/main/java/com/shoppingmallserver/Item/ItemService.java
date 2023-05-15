package com.shoppingmallserver.Item;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public List<ItemEntity> allItemView() {
        return itemRepository.findAll();
    }

    public ItemEntity getProductDetails(Long id) {

        return itemRepository.findById(id).get();
    }

    @Transactional
    public String additem(ItemRequest request) {
        itemRepository.save(ItemEntity.builder()
                .name(request.getName())
                .imgPath(request.getImgPath())
                .price(request.getPrice())
                .content(request.getContent())
                .build());
        return "상품이 추가되었습니다.";
    }

    @Transactional
    public Item modify(ItemRequest request, Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(() ->
                new BadCredentialsException("잘못된 아이템 번호 입니다."));

        itemEntity.setName(request.getName());
        itemEntity.setImgPath(request.getImgPath());
        itemEntity.setPrice(request.getPrice());
        itemEntity.setContent(request.getContent());

        return Item.fromEntity(itemRepository.save(itemEntity));
    }

    @Transactional
    public void delete(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(() ->
                new BadCredentialsException("잘못된 아이템 번호 입니다."));
        itemRepository.delete(itemEntity);
    }


}