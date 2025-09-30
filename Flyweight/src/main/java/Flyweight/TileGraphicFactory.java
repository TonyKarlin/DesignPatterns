package Flyweight;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class TileGraphicFactory {
    private static final Map<TileType, TileImage> graphics = new HashMap<>();

    public static TileImage getGraphic(TileType type) {
        TileImage graphic = graphics.get(type);
        if (graphic == null) {
            switch (type) {
                case BUILDING -> graphic = new TileImage("/building.jpg", "Building tile");
                case FOREST -> graphic = new TileImage("/forest.jpg", "Forest tile");
                case ROAD -> graphic = new TileImage("/road.jpg", "Road tile");
                case SWAMP -> graphic = new TileImage("/swamp.jpg", "Swamp tile");
                case WATER -> graphic = new TileImage("/water.jpg", "Water tile");
                default -> throw new IllegalArgumentException("Unknown tile type: " + type);
            }
            graphics.put(type, graphic);
        }
        return graphic;
    }
}
