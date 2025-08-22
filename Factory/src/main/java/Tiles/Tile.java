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

        char letter = getType().charAt(0);
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

    public String getType();

    public void action();
}
