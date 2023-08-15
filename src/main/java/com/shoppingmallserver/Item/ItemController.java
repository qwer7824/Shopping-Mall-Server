package com.shoppingmallserver.Item;

import com.shoppingmallserver.Member.Member;
import com.shoppingmallserver.Member.SignRequest;
import com.shoppingmallserver.Member.SignResponse;
import com.shoppingmallserver.Member.SignService;
import com.shoppingmallserver.cart.CartService;
import com.shoppingmallserver.config.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;


import java.io.IOException;
import java.util.List;

import static com.shoppingmallserver.config.ResponseDTO.ok;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseDTO<List<ItemEntity>> getItems() {
        return ok(itemService.allItemView());
    }

    @PostMapping(value = "/admin/additem")
    public ResponseDTO<ItemResponse> addItem(@RequestBody ItemRequest request) {
        return ok(itemService.addItem(request));
    }

    @GetMapping("/item/{itemId}")
    public ResponseDTO<ItemResponse> getProductDetails(@PathVariable Long itemId) {
        return ok(itemService.getProductDetails(itemId));
    }

    @PutMapping("/admin/{itemId}")
    public ResponseDTO<ItemEntity> modify(@PathVariable Long itemId, @RequestBody ItemRequest request){
        return ok(itemService.modify(request,itemId));
    }
    @DeleteMapping("/admin/{itemId}")
    public ResponseDTO<Void> delete(@PathVariable Long itemId){
        itemService.delete(itemId);
        return ok();
    }


}
