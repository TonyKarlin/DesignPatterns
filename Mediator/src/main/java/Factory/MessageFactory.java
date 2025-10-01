package Factory;

public abstract class MessageFactory {
    public abstract Message createMessage(String username, String text);
}
