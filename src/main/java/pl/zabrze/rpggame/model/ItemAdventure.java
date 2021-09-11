package pl.zabrze.rpggame.model;

public class ItemAdventure extends Adventure{
    private Item item;

    public ItemAdventure(String content, String location, Item item) {
        super(content, location);
        this.item = item;
    }

    @Override
    public String description() {
        return "Znalazłeś cenny przedmiot: " + item.getName();
    }
}
