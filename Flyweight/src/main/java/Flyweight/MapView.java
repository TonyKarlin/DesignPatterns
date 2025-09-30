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

import java.awt.*;

public class MapView extends Application {
    private static Map injectedMap;
    private static final int TILE_SIZE = 64;
    private MapController controller;
    private Canvas canvas;
    private GraphicsContext gc;


    @Override
    public void start(Stage stage) {
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
        for (int i = 0; i < controller.getTiles().size(); i++) {
            Tile tile = controller.getTiles().get(i);
            int x = (i % width) * TILE_SIZE;
            int y = (i / width) * TILE_SIZE;

            TileType type = getTileType(tile);
            TileImage image = TileGraphicFactory.getGraphic(type);
            Image img = image.getImage();

            gc.drawImage(img, x, y, TILE_SIZE, TILE_SIZE);
        }
    }

    private void showMap(Stage stage) {
        controller = new MapController(injectedMap);
        int CANVAS_WIDTH = controller.getWidth() * TILE_SIZE;
        int CANVAS_HEIGHT = controller.getHeight() * TILE_SIZE;
        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        Scene mapScene = new Scene(root, CANVAS_WIDTH, CANVAS_HEIGHT);
        stage.setScene(mapScene);
        stage.setTitle("Flyweight Pattern - Map View");
        drawMap();
    }

    public TileType getTileType(Tile tile) {
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
