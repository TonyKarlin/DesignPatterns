package Flyweight;

import Factory.Maps.Map;
import Factory.Tiles.Tile;

import java.util.ArrayList;
import java.util.List;

public class MapController {
    private static final int width = 10;
    private static final int height = 10;
    private final List<Tile> tiles;

    public MapController(Map map) {
        map.display(width, height);
        this.tiles = new ArrayList<>();
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
