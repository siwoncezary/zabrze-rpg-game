package pl.zabrze.rpggame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zabrze.rpggame.entity.Player;
import pl.zabrze.rpggame.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

/*
Cwiczenie 4
1. Zdefiniuj klasę encji Item z polami:
  - long id
  - String name
  - int price
2. Zdefniuj repozytorium dla Item
3. Zdefniuj klasę kontrolera ItemRestController
4. Dodaj pole z repozytorium w ItemRestControler
5. Zdefniuj metody do endopointów
  - /api/2/items POST - tworzenie item
  - /api/2/items GET - pobranie wszystkich item
 */


@RestController
public class PlayersRestControllerWithJpa {
    final PlayerRepository playerRepository;

    public PlayersRestControllerWithJpa(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @PostMapping("/api/2/players")
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer){
        Player save = playerRepository.save(newPlayer);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/api/2/players")
    public List<Player> players(){
        return playerRepository.findAll();
    }

    @DeleteMapping("/api/2/players/{id}")
    public ResponseEntity<Player> deletePlayer(@PathVariable long id){
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            playerRepository.delete(player.get());
        }
        return ResponseEntity.of(player);
    }

    @GetMapping("/api/2/players/{id}")
    public ResponseEntity<Player> player(@PathVariable long id){
        return ResponseEntity.of(playerRepository.findById(id));
    }
    /*
    Ćwiczenie 5
    Zdefiniuj metodę odszukiwania pojedynczego przedmiotu w ItemRestController
     */
}
