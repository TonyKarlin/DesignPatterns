package Factory.Maps;

import Factory.Tiles.ForestTile;
import Factory.Tiles.SwampTile;
import Factory.Tiles.Tile;
import Factory.Tiles.WaterTile;


public class WildernessMap extends Map {
    @Override
    public Tile createTile() {
        int rand = (int) (Math.random() * 3);

        return (rand == 1) ? new SwampTile() : (rand == 2) ? new WaterTile() : new ForestTile();
    }
}
