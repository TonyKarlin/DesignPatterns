package MVC;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class View extends Application {
    private int chosenSize;
    private boolean useMouseInput = false;

    @Override
    public void start(Stage primaryStage) throws Exception {
        showMenu(primaryStage);
    }

    public void showMenu(Stage stage) {
        Label label = new Label("Choose editor size. (Cannot be odd numbers)");
        TextField size = new TextField();

        Label inputLabel = new Label("Input: ");
        inputLabel.setFont(Font.font("System", FontWeight.BOLD, 14));
        ToggleButton inputToggle = new ToggleButton("Arrow Keys");
        inputToggle.setSelected(false); // default: arrow keys
        inputToggle.setOnAction(e ->  {
            useMouseInput = inputToggle.isSelected();
            if (useMouseInput) {
                inputToggle.setText("Mouse Input");
            } else {
                inputToggle.setText("Arrow Keys");
            }
        });

        Button confirm = new Button("Confirm");
        Label error = new Label();
        error.setTextFill(Color.RED);

        HBox inputs = new HBox(8, inputLabel, inputToggle);
        inputs.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, label, size, inputs, confirm,  error);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor Setup");
        stage.show();

        confirm.setOnAction(e -> {
            try {
                int value = Integer.parseInt(size.getText().trim());
                if (value % 2 != 0) {
                    error.setText("Number must be even!");
                } else {
                    setChosenSize(value);
                    stage.close();

                    Controller controller = new Controller(value, isUseMouseInput());
                    Stage editorStage = new Stage();
                    controller.createAGrid(editorStage);
                }
            } catch (NumberFormatException ex) {
                error.setText("Please enter a valid number!");
            }
        });
    }

    public int getChosenSize() {
        return chosenSize;
    }

    public void setChosenSize(int chosenSize) {
        this.chosenSize = chosenSize;
    }

    public boolean isUseMouseInput() {
        return useMouseInput;
    }
}
