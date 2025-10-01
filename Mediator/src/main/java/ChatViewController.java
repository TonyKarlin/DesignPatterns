import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatViewController {

    public void initialize(ChatClient client, ChatMediator mediator) {

        for (ChatClient c : mediator.getClients()) {
            if (!c.getUsername().equals(client.getUsername())) {
                recipientsList.getItems().add(c.getUsername());
            }
        }

        msgButton.setOnAction(e -> {
            String message = msgField.getText();
            if (!message.isEmpty()) {
                client.sendMessage(message);
                listView.getItems().add(client.getUsername() + ": " + message);
                msgField.clear();
            }
        });

    }

    public void displayReceivedMessage(String message) {
        listView.getItems().add(message);
    }

    @FXML
    private ListView<String> listView;

    @FXML
    private TextField msgField;

    @FXML
    private Button msgButton;

    @FXML
    private ListView<String> recipientsList;
}
