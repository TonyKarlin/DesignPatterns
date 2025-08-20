package Tiles;

import java.util.Map;
import java.util.Objects;

public interface Tile {
    default String getCharacter() {
        // AI generated colours
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String grey = "\u001B[37m";
        String reset = "\u001B[0m";

        char letter = getClass().getSimpleName().charAt(0);
        String color = switch (letter) {
            case 'S' -> green;
            case 'F' -> yellow;
            case 'W' -> blue;
            case 'B' -> red;
            case 'R' -> grey;
            default -> reset;
        };

        return color + letter + reset;
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
