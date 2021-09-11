package pl.zabrze.rpggame.model;

import java.util.List;

public class Hero {
    private String name;
    private Player player;
    private List<Item> inventory;
    private int money;

    public Hero(String name, Player player, List<Item> inventory) {
        this.name = name;
        this.player = player;
        this.inventory = inventory;
        this.money = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
