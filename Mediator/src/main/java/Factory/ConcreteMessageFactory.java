package Factory;

public class ConcreteMessageFactory extends MessageFactory {

    @Override
    public Message createMessage(String username, String text) {
        return new TextMessage(username, text);
    }
}
