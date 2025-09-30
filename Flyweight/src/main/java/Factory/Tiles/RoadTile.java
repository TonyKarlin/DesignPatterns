package Factory.Tiles;

public class RoadTile implements Tile{
    public String type = "Road";

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
