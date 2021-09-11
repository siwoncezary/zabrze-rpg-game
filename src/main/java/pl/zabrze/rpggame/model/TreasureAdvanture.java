package pl.zabrze.rpggame.model;

public class TreasureAdvanture extends Adventure{
    private int money;

    public TreasureAdvanture(String content, String location, int money) {
        super(content, location);
        this.money = money;
    }

    @Override
    public String description() {
        return "Znalazłeś złoto w ilości: " + money;
    }

    @Override
    public void accept(Hero hero) {
        hero.setMoney(hero.getMoney() + money);
    }
}
