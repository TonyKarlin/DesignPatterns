package MVC;

import Commands.GeneratePixelCodeCommand;
import Commands.MovementCommand;
import Commands.TogglePixelCommand;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controller {
    private final int gridSize;
    private final boolean useMouseInput;

    private final Model model;
    private static final int CELL_SIZE = 40;
    private final Rectangle[][] rectangles;


    public Controller(int gridSize, boolean useMouseInput) {
        this.gridSize = gridSize;
        this.useMouseInput = useMouseInput;
        this.model = new Model(gridSize);
        this.rectangles = new Rectangle[gridSize][gridSize];
        model.addListener((this::updateCell));
    }

    // Uses Every Movement Command and the TogglePixelCommand
    private void setupInputHandlers(Scene scene) {
        if (useMouseInput) {
            for (int r = 0; r < gridSize; r++) {
                for (int c = 0; c < gridSize; c++) {
                    int row = r, col = c;
                    rectangles[r][c].setOnMouseClicked(e ->
                        new TogglePixelCommand(model, row, col).execute()
                    );
                }
            }
        } else {
            MovementCommand moveCmd = new MovementCommand(model);
            scene.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case UP -> moveCmd.move("UP");
                    case DOWN -> moveCmd.move("DOWN");
                    case LEFT -> moveCmd.move("LEFT");
                    case RIGHT -> moveCmd.move("RIGHT");
                    case SPACE -> new TogglePixelCommand(model,
                            model.getCursorRow(), model.getCursorCol()).execute();
                }
                System.out.println("Key pressed: " + e.getCode());
                updateCell(model.getCursorRow(), model.getCursorCol());
            });
        }
    }


    public void createAGrid(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                Rectangle rect = createRectangle();
                rectangles[r][c] = rect;
                grid.add(rect, c, r);
            }
        }
        Scene scene = createCodeButtonAndStage(stage, grid);
        setupInputHandlers(scene);

        grid.requestFocus();
    }

    // Uses GeneratePixelCodeCommand
    public Scene createCodeButtonAndStage(Stage stage, GridPane gridPane) {
        Button codeButton = new Button("Create Code");
        codeButton.setOnMouseClicked(e -> {
            new GeneratePixelCodeCommand(model, "pixelArt").execute();
        });
        VBox root = new VBox(10, gridPane, codeButton);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root);
        stage.setTitle("Pixel Editor (" + gridSize + " x " + gridSize + ")");
        stage.setScene(scene);
        stage.show();
        return scene;
    }

    public Rectangle createRectangle() {
        Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.LIGHTGRAY);
        return rect;
    }

    public void updateCell(int row, int col) {
        boolean[][] pixels = model.getPixels();
        int cursorRow = model.getCursorRow();
        int cursorCol = model.getCursorCol();

        for (int r = 0; r < gridSize; r++) {
            for (int c = 0; c < gridSize; c++) {
                rectangles[r][c].setFill(pixels[r][c] ? Color.BLACK : Color.WHITE);

                if (!useMouseInput && r == cursorRow && c == cursorCol) {
                    rectangles[r][c].setStroke(Color.BLUE);
                    rectangles[r][c].setStrokeWidth(2);
                } else {
                    rectangles[r][c].setStroke(Color.LIGHTGRAY);
                    rectangles[r][c].setStrokeWidth(1);
                }
            }
        }
    }
}
