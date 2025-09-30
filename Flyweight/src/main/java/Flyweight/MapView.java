package Flyweight;

import Factory.Maps.CityMap;
import Factory.Maps.Map;
import Factory.Maps.WildernessMap;
import Factory.Tiles.Tile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.canvas.Canvas;


public class MapView extends Application {
    private static Map injectedMap;
    private static final int TILE_SIZE = 64; // Define a constant tile size for rendering
    private MapController controller;
    private Canvas canvas;
    private GraphicsContext gc;


    @Override
    public void start(Stage stage) {
        // Renders a super simple menu to select between the two maps created with the Factory pattern
        stage.setTitle("Select Map");

        Button cityBtn = new Button("City");
        Button wildBtn = new Button("Wilderness");

        cityBtn.setOnAction(e -> {
            setMap(new CityMap());
            showMap(stage);
        });

        wildBtn.setOnAction(e -> {
            setMap(new WildernessMap());
            showMap(stage);
        });

        VBox menu = new VBox(10, cityBtn, wildBtn);
        Scene menuScene = new Scene(menu, 200, 100);
        stage.setScene(menuScene);
        stage.show();
    }


    public void drawMap() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int width = controller.getWidth();

        // Construct the map by drawing each tile at its calculated position
        // based on its index in the tile list
        for (int i = 0; i < controller.getTiles().size(); i++) {
            Tile tile = controller.getTiles().get(i); // Get the tile at index i
            int x = (i % width) * TILE_SIZE; // Calculate x position based on column
            int y = (i / width) * TILE_SIZE; // Calculate y position based on row

            TileType type = getTileType(tile); // Get the TileType enum from the tile's type string
            TileImage image = TileGraphicFactory.getGraphic(type); // Get the shared TileImage from the graphic factory
            Image img = image.getImage(); // Get the actual Image object

            // Draw the image at the calculated position with the defined tile size
            gc.drawImage(img, x, y, TILE_SIZE, TILE_SIZE);
        }
    }

    private void showMap(Stage stage) {
        // Initialize the controller with the injected map chosen by the user
        controller = new MapController(injectedMap);

        int CANVAS_WIDTH = controller.getWidth() * TILE_SIZE; // Calculate canvas width based on map width and tile size
        int CANVAS_HEIGHT = controller.getHeight() * TILE_SIZE; // Calculate canvas height based on map height and tile size

        // Set up the canvas and graphics context for drawing
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        Scene mapScene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT);
        stage.setScene(mapScene);
        stage.setTitle("Flyweight Pattern - Map View");
        drawMap(); // Draw the map on the canvas
    }

    public TileType getTileType(Tile tile) {
        // Convert the tile's type string to the corresponding TileType enum
        String type = tile.getType().toUpperCase();
        return switch (type) {
            case "ROAD" -> TileType.ROAD;
            case "WATER" -> TileType.WATER;
            case "BUILDING" -> TileType.BUILDING;
            case "FOREST" -> TileType.FOREST;
            case "SWAMP" -> TileType.SWAMP;
            default -> null;
        };
    }

    public static void setMap(Map map) {
        injectedMap = map;
    }
}
