import Factory.Message;

import java.util.List;

public interface ChatMediator {
    void sendMessage(Message message);

    void registerClient(ChatClient client);

    void removeClient(ChatClient client);

    List<ChatClient> getClients();
}
