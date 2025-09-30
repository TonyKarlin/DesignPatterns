package Flyweight;

import Factory.Maps.Map;
import Factory.Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    private final int width = 10;
    private final int height = 10;
    private final List<Tile> tiles;

    public MapController(Map map) {
        map.display(width, height); // Displays the map in the console for verification
        this.tiles = new ArrayList<>();

        // Initializes the game tiles
        for (int i = 0; i < width * height; i++) {
            tiles.add(map.createTile());
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
