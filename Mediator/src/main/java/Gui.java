import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Gui extends Application {

    public static void show(ChatClient client, ChatMediator mediator) throws Exception {
        URL fxml = Gui.class.getResource("/chat_window.fxml");
        FXMLLoader loader = new FXMLLoader(fxml);
        Parent root = loader.load();
        ChatViewController controller = loader.getController();
        controller.initialize(client, mediator);

        if (client instanceof ConcreteChatClient) {
            ((ConcreteChatClient) client).setController(controller);
        }

        Stage stage = new Stage();
        stage.setTitle(client.getUsername() + "'s Chat Window");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ChatMediator mediator = ConcreteChat.getInstance();

        String[] usernames = {"Bob", "Jerry", "Don"};
        for (String username : usernames) {
            ChatClient client = new ConcreteChatClient(username, mediator);
            mediator.registerClient(client);
        }

        for (ChatClient client : mediator.getClients()) {
            Gui.show(client, mediator);
        }
    }
}
