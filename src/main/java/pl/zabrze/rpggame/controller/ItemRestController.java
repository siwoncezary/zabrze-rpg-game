package pl.zabrze.rpggame.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zabrze.rpggame.entity.Item;
import pl.zabrze.rpggame.repository.ItemRepository;

import java.util.List;

@RestController
public class ItemRestController {
    final ItemRepository itemRepository;

    public ItemRestController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostMapping("/api/2/items")
    public ResponseEntity<Item> createItem(@RequestBody Item newItem){
        Item save = itemRepository.save(newItem);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/api/2/items")
    public List<Item> items(){
        return itemRepository.findAll();
    }
}
