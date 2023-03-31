package com.shoppingmallserver.Item;

import com.shoppingmallserver.Member.SignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
    @PostMapping(value = "/additem")
    public ResponseEntity<String> additem(@RequestBody ItemRequest request) throws Exception {
        return new ResponseEntity<>(itemService.additem(request), HttpStatus.OK);
    }

}
