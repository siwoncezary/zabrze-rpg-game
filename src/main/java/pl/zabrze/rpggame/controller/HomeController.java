package pl.zabrze.rpggame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.zabrze.rpggame.model.Player;

@Controller
public class HomeController {
    Player player = new Player("Karol", 23, "abcd");

    @GetMapping("/")
    public String home() {
        return "index";
    }

    /*
    Cwiczenie 1
    Dodaj metodę obsługującą ścieżkę /game
    która wyświetli plik game.jsp
    Utwórz plik game.jsp i dodaj w nim komunikat GAME
     */

    @GetMapping("/game")
    public String game() {
        return "game";
    }

    @GetMapping("/register/form")
    public String registerForm() {
        return "register-form";
    }

    @PostMapping("/register")
    public String register(Player player, Model model) {
        this.player = player; //zapamiętujemy gracza
        model.addAttribute("playerName", this.player.getPlayerName());
        model.addAttribute("wiek", this.player.getAge());
        return "register";
    }

    /*
    Cwiczenie 2
    Dodaj metodę GET obsługującą ścieżkę /sum w której występuje query z parametrami a i b
    W odpowiedzi wyślij stronę z sumą a + b np. plik sum.jsp z komunikatem Suma = 13 (np. dla a = 7 i b = 6)
     */
    @GetMapping("/sum")
    public String sum(@RequestParam double a, @RequestParam double b, Model model) {
        model.addAttribute("sum", a + b);
        return "sum";
    }

    /*
    Cwiczenie 3
    Dodaj metodę wyswietlająca formularz sum-form.jsp do wpisania liczb a i b, aby po jego zatwierdzeniu
    wyświetlała się strona sum.jsp z wynikiem sumowania
     */

    @GetMapping("/login")
    public String loginForm() {
        return "login-form";
    }
    /*
    Stwórz login-form.jsp z polami na nazwę użytkownika i jego hasło
    metoda post i action do /login
     */

    @PostMapping("/login")
    public String login(Player loggedPlayer) {
        if (
                loggedPlayer.getPlayerName().equals(player.getPlayerName())
                        && loggedPlayer.getPassword().equals(player.getPassword())
        ) {
            return "login";
        } else {
            return "login-error";
        }
    }

}
