package pl.zabrze.rpggame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zabrze.rpggame.model.Adventure;
import pl.zabrze.rpggame.model.Hero;
import pl.zabrze.rpggame.model.Item;
import pl.zabrze.rpggame.model.Player;
import pl.zabrze.rpggame.service.AdventureService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
    private final AdventureService adventureService;
    Hero hero = new Hero(
            "tom",
            new Player("Karol", 12, "abcd"),
            new ArrayList<>()
    );
    List<Item> cityShop = new ArrayList<>(List.of(
            new Item("Sword", 3),
            new Item("Health potion", 2),
            new Item("Knife", 1)
    ));
    Adventure lastAdventure;

    public GameController(AdventureService adventureService) {
        this.adventureService = adventureService;
    }

    @GetMapping("/start")
    public String start(Model model){
        model.addAttribute("hero", hero);
        return "/game/city";
    }

    @GetMapping("/shop")
    public String buy(Model model){
        model.addAttribute("hero", hero);
        model.addAttribute("items", cityShop);
        return "/game/city-shop";
    }

    @GetMapping("/buy")
    public String buyItem(@RequestParam int id){
        Item item = cityShop.remove(id);
        hero.setMoney(hero.getMoney() - item.getPrice());
        hero.getInventory().add(item);
        return "redirect:/start";
    }

    @GetMapping("/adventure")
    public String infoAdventure(Model model){
        lastAdventure = adventureService.randomAdventure();
        model.addAttribute("adventure", lastAdventure);
        return "/game/adventure-info";
    }

    @GetMapping("/takepart")
    public String takePart(Model model){
        if (lastAdventure == null){
            return "redirect:/adventure";
        }
        lastAdventure.accept(hero);
        model.addAttribute("hero", hero);
        return "/game/hero-info";
    }
}
