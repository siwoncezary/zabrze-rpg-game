package pl.zabrze.rpggame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zabrze.rpggame.entity.Item;
import pl.zabrze.rpggame.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Collections;
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

    @GetMapping("/api/2/items/{id}")
    public ResponseEntity<Item> item(@PathVariable long id){
        return ResponseEntity.of(itemRepository.findById(id));
    }

    @GetMapping("/api/2/items/search-price")
    public List<Item> findByPrice(@RequestParam(value = "price") String priceParam){
        if (priceParam.equals("max")){
            List<Item> list = itemRepository.findAll();
            int max = Integer.MIN_VALUE;
            for(Item item: list){
                int price = item.getPrice();
                if (price > max){
                    max = price;
                }
            }
            List<Item> result = new ArrayList<>();
            for(Item item: list){
                if (item.getPrice() == max){
                    result.add(item);
                }
            }
            return result;
        } else {
            return Collections.emptyList();
        }
    }

    @GetMapping("/api/2/items/search-name")
    public ResponseEntity<Item> findByName(@RequestParam String name){
        List<Item> list = itemRepository.findAll();
        for (Item item: list){
            if (item.getName().equals(name)){
                return ResponseEntity.ok(item);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
