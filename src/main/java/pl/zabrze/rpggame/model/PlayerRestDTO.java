package pl.zabrze.rpggame.model;

public class PlayerRestDTO {
    private String playerName;
    private int age;

    public PlayerRestDTO() {
    }

    public PlayerRestDTO(String playerName, int age) {
        this.playerName = playerName;
        this.age = age;
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
}
