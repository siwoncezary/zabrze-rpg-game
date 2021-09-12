package pl.zabrze.rpggame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zabrze.rpggame.model.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayersRestController {
    List<Player> players = new ArrayList<>(List.of(
            new Player("adam", 22, "1234"),
            new Player("ewa", 25, "abcd"),
            new Player("karol", 34, "rtyu12")
    ));
    List<Item> items = new ArrayList<>(List.of(
            new Item("Sword", 12),
            new Item("Bread", 2),
            new Item("Knife", 3)
    ));

    @PatchMapping("/api/players/{id}")
    public ResponseEntity<Player> updateAge(@PathVariable int id,
                                            @RequestBody PlayerAgeUpdate update){
        Player player = players.get(id);
        player.setAge(update.age);
        return ResponseEntity.ok(player);
    }
    /*
       Cwiczenie 3
       Dodaj metodę post do dodawania nowych przedmiotów
       /api/items
     */
    @PostMapping("/api/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer){
        players.add(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @DeleteMapping("/api/players/{id}")
    public ResponseEntity<PlayerRestDTO> deletePlayer(@PathVariable int id){
        if (id >= 0 && id < players.size()){
            Player player = players.remove(id);
            return ResponseEntity.ok(new PlayerRestDTO(player.getPlayerName(), player.getAge()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /*
    Cwiczenie 2
    Zdefiniuj metodę zwracającą jeden przedmiot pod endpointem:
    /api/items/{id}
     */
    @GetMapping("/api/players/{id}")
    public ResponseEntity<PlayerRestDTO> player(@PathVariable(value = "id") int id) {
        if (id >= 0 && id < players.size()) {
            Player player = players.get(id);
            return ResponseEntity.ok(new PlayerRestDTO(player.getPlayerName(), player.getAge()));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/api/players")
    public List<PlayerRestDTO> players() {
        List<PlayerRestDTO> list = new ArrayList<>();
        for (Player player : players) {
            list.add(new PlayerRestDTO(player.getPlayerName(), player.getAge()));
        }
        return list;
    }

    /*
    Ćwiczenie 1
    napisz endpoint zwracający JSON z przedmiotami w grze rpg
    /api/items
     */
    @GetMapping("/api/items")
    public List<Item> items() {
        return items;
    }
}
