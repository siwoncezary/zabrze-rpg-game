package pl.zabrze.rpggame.service;

import org.springframework.stereotype.Service;
import pl.zabrze.rpggame.model.*;

import java.util.Random;

@Service
public class AdventureService {
    private static final Random random = new Random();

    public Adventure randomAdventure(){
        switch(random.nextInt(3)){
            case 0:
                return new ItemAdventure("","Pustynia", new Item("Kij bojowy", 12));
            case 1:
                return new TreasureAdvanture("","Pałać", 4);
                /*
                Zdefniuj klasę MessageAdventure, która zawiera informację o skarbie
                zwróć obiekt tej klasy, dla przypdaku 2
                 */
            case 2:
                return new MessageAdventure("","Pustkowie", "Pogłoska o skarbie");
            default:
                return new ItemAdventure("","Pustynia", new Item("Kij bojowy", 12));
        }
    }
}
