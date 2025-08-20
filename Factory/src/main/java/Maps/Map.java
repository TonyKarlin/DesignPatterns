package Maps;

import Tiles.Tile;

public abstract class Map {
    public void display(int w, int h) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Tile tile = createTile();
                System.out.println(tile.getCharacter());
            }
        }

    }

    public abstract Tile createTile();
}
