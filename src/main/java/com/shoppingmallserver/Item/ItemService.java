package com.shoppingmallserver.Item;

import com.shoppingmallserver.Exception.BaseException;
import com.shoppingmallserver.Exception.ResultType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public List<ItemEntity> allItemView() {
        return itemRepository.findAll();
    }

    public ItemResponse getProductDetails(Long id) {
        ItemEntity itemEntity = itemRepository.findById(id).orElseThrow(()->{
            throw new BaseException(ResultType.SYSTEM_ERROR);
        });
        return modelMapper.map(itemEntity,ItemResponse.class);
    }

    public ItemResponse addItem(ItemRequest request) {

       ItemEntity itemEntity = modelMapper.map(request,ItemEntity.class);

        ItemEntity saved = itemRepository.save(itemEntity);

        return modelMapper.map(saved, ItemResponse.class);
    }

    @Transactional
    public ItemEntity modify(ItemRequest request, Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(() ->
                new BaseException(ResultType.SYSTEM_ERROR));

        itemEntity.setName(request.getName());
        itemEntity.setImgPath(request.getImgPath());
        itemEntity.setPrice(request.getPrice());
        itemEntity.setContent(request.getContent());

        return itemRepository.save(itemEntity);
    }

    @Transactional
    public void delete(Long itemId) {
        ItemEntity itemEntity = itemRepository.findById(itemId).orElseThrow(() ->
                new BaseException(ResultType.SYSTEM_ERROR));
        itemRepository.delete(itemEntity);
    }


}