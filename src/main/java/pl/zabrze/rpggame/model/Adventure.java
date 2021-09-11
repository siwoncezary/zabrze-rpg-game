package pl.zabrze.rpggame.model;

abstract public class Adventure {
    private String content;
    private String location;

    public Adventure(String content, String location) {
        this.content = content;
        this.location = location;
    }

    public Adventure() {
    }

    public String getContent() {
        return content;
    }

    public String getLocation() {
        return location;
    }

    public abstract String description();
}
