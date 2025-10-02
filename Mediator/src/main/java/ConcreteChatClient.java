import Factory.ConcreteMessageFactory;
import Factory.Message;
import Factory.MessageFactory;

public class ConcreteChatClient implements ChatClient {
    private final String username;
    private final MessageFactory messageFactory = new ConcreteMessageFactory();
    private final ChatMediator mediator;
    private ChatViewController controller;

    public ConcreteChatClient(String username,
                              ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(Message message) {
        String formattedMessage = message.getUsername() + ": " + message.getMessage();
        if (controller != null) {
            controller.displayReceivedMessage(formattedMessage);
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void sendMessage(String content, String recipient) {
        Message message = messageFactory.createMessage(this.username, content);
        mediator.sendMessage(message, recipient);
    }

    public MessageFactory getMessageFactory() {
        return messageFactory;
    }

    public ChatMediator getMediator() {
        return mediator;
    }

    public void setController(ChatViewController controller) {
        this.controller = controller;
    }
}
