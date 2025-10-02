import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatViewController {
    private String selectedRecipient = null;

    public void initialize(ChatClient client, ChatMediator mediator) {
        recipientsList.getItems().add("All");
        for (ChatClient c : mediator.getClients()) {
            if (!c.getUsername().equals(client.getUsername())) {
                recipientsList.getItems().add(c.getUsername());
            }
        }
        recipientsList.getSelectionModel().select("All");

        recipientsList.getSelectionModel().selectedItemProperty()
                .addListener((_, _, newValue) -> {
                    selectedRecipient = newValue;
                });

        msgButton.setOnAction(e -> {
            String message = msgField.getText();
            if (!message.isEmpty()) {
                if ("All".equals(selectedRecipient) || selectedRecipient == null) {
                    for (ChatClient c : mediator.getClients()) {
                        if (!c.getUsername().equals(client.getUsername())) {
                            client.sendMessage(message, c.getUsername());
                        }
                    }
                } else {
                    client.sendMessage(message, selectedRecipient);
                }
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
