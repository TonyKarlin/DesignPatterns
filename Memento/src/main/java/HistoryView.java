import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HistoryView {
    private Controller controller;

    public HistoryView(Controller controller) {
        this.controller = controller;
    }

    public void show() {
        Stage stage = new Stage();
        VBox vBox = new VBox(10);
        ListView<String> listView = new ListView<>();
        Label label = new Label("Select a state to restore (10 previous actions are shown)");

        for (IMemento memento : controller.getUndoHistory()) {
            listView.getItems().add(memento.getTimestamp());
        }

        listView.setOnMouseClicked(event -> {
            int index = listView.getSelectionModel().getSelectedIndex();
            if (index >= 0 && index < controller.getUndoHistory().size()) {
                IMemento selectedMemento = controller.getUndoHistory().get(index);
                controller.restoreStateFromHistory(selectedMemento);
            }
        });

        vBox.getChildren().addAll(label, listView);
        stage.setScene(new Scene(listView, 300, 300));
        stage.setTitle("History");
        stage.show();
    }
}
