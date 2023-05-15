package com.shoppingmallserver.Item;

import com.shoppingmallserver.Member.SignRequest;
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

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<?> getitems() {
        return ResponseEntity.ok().body(itemService.allItemView());
    }
    @PostMapping(value = "/admin/additem")
    public ResponseEntity<String> additem(@RequestBody ItemRequest request) {
        return new ResponseEntity<>(itemService.additem(request), HttpStatus.OK);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<?> getProductDetails(@PathVariable Long itemId) {

        return ResponseEntity.ok().body(itemService.getProductDetails(itemId));
    }

    @PutMapping("/admin/{itemId}")
    public ResponseEntity<Item> modify(@PathVariable Long itemId, @RequestBody ItemRequest request){
        return new ResponseEntity<>(itemService.modify(request, itemId),HttpStatus.OK);
    }
    @DeleteMapping("/admin/{itemId}")
    public ResponseEntity<Void> delete(@PathVariable Long itemId){
        itemService.delete(itemId);
        return ResponseEntity.noContent().build();
    }

}
