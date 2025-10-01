import Factory.Message;

import java.util.ArrayList;
import java.util.List;

public class ConcreteChat implements ChatMediator {
    private static ConcreteChat instance;
    private List<ChatClient> clients;

    private ConcreteChat() {
        this.clients = new ArrayList<>();
    }

    public static ConcreteChat getInstance() {
        if (instance == null) {
            instance = new ConcreteChat();
        }
        return instance;
    }

    @Override
    public void sendMessage(Message message) {
        for (ChatClient client : clients) {
            if (!client.getUsername().equals(message.getUsername())) {
                client.receiveMessage(message);
            }
        }
    }

    @Override
    public void registerClient(ChatClient client) {
        clients.add(client);
    }

    @Override
    public void removeClient(ChatClient client) {
        clients.remove(client);
    }

    @Override
    public List<ChatClient> getClients() {
        return clients;
    }

    public void setClients(List<ChatClient> clients) {
        this.clients = clients;
    }
}
