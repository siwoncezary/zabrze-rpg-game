package pl.zabrze.rpggame.model;

public class MonsterAdventure extends Adventure{
    private Item item;
    private int money;
    private String monster;
    private int healthLevel;
    private int hp;

    public MonsterAdventure(String content, String location, Item item, int money, String monster) {
        super(content, location);
        this.item = item;
        this.money = money;
        this.monster = monster;
    }

    @Override
    public String description() {
        return "Zostałeś zaatakowany " + monster;
    }

    @Override
    public void accept(Hero hero) {
        if (hero.getHealthLevel() > 0){
            healthLevel -= hero.getExperience();
            hero.setHealthLevel(hero.getHealthLevel() - hp);
            if (healthLevel <= 0){
                hero.getInventory().add(item);
                hero.setMoney(hero.getMoney() + money);
                hero.setExperience(hero.getExperience() + 1);
            }
        }
    }
}
