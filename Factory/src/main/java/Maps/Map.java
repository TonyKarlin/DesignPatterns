package Maps;

import Tiles.Tile;

public abstract class Map {
    public void display(int w, int h) {
        for (int i = 0; i < h + 2; i++) {
            // Some framing for the map. Very unneccessary but looks good :)
            if (i == 0 || i == h + 1) {
                for (int k = 0; k < w + 2; k++) {
                    if (k == 0) System.out.print("- ");
                    else if (k == w + 2) System.out.print(" -");
                    else System.out.print(" - ");
                }
                System.out.println();
            } else {
                for (int j = 0; j < w + 2; j++) {
                    // More framing
                    if (j == 0) System.out.print("| ");
                    else if (j == w + 1) System.out.print(" |");
                    else {
                        // Actual logic for generating the tileset for the map.
                        Tile tile = createTile();
                        System.out.print(" " + tile.getCharacter() + " ");
                    }
                }
                System.out.println();
            }
        }

    }

    public abstract Tile createTile();
}
