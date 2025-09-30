package Factory.Tiles;


public class ForestTile implements Tile {
    public String type = "Forest";

    @Override
    public char getCharacter() {
        return getType().charAt(0);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void action() {

    }
}
