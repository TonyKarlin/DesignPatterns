package Maps;

import Tiles.*;

public class CityMap extends Map{
    @Override
    public Tile createTile() {
        int rand = (int) (Math.random() * 3);

        return (rand == 1) ? new BuildingTile() : (rand == 2) ? new RoadTile() : new ForestTile();
    }
}
