import Factory.Message;

public interface ChatClient {
    void receiveMessage(Message message);

    String getUsername();

    void sendMessage(String content);
}
