package Tiles;

import java.util.Map;
import java.util.Objects;

public interface Tile {
    default char getCharacter() {
        return getClass().getSimpleName().charAt(0);
    }

    default String getDescription() {
        Map<String, String> desc = Map.of(
                "BuildingTile", "This is a Building Tile.",
                "RoadTile", "This is a Road Tile.",
                "ForestTile", "This is a Forest Tile.",
                "WaterTile", "This is a Water Tile.",
                "SwampTile", "This is a Swamp Tile."
        );

        return desc.getClass().getSimpleName();
    }

    public void action();
}
