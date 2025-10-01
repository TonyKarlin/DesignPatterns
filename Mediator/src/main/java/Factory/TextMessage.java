package Factory;

public record TextMessage(String username, String text) implements Message {
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getMessage() {
        return text;
    }
}
