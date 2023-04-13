package com.shoppingmallserver.Item;

import com.shoppingmallserver.Member.SignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(value = "/additem")
    public ResponseEntity<String> additem(@RequestBody ItemRequest request) throws Exception {
        return new ResponseEntity<>(itemService.additem(request), HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable Long id) {

        return ResponseEntity.ok().body(itemService.getProductDetails(id));
    }
}
