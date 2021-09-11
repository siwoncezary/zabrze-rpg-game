package pl.zabrze.rpggame.model;

public class MessageAdventure extends Adventure{
    private String message;

    public MessageAdventure(String content, String location, String message) {
        super(content, location);
        this.message = message;
    }

    @Override
    public String description() {
        return message + " w " + getLocation();
    }
}
