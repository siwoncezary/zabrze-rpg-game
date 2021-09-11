package pl.zabrze.rpggame.model;

public class Player {
    private String playerName;
    private int age;
    private String password;

    public Player(String playerName, int age, String password) {
        this.playerName = playerName;
        this.age = age;
        this.password = password;
    }

    public Player() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
