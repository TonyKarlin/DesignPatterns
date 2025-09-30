package Factory.Tiles;


public class WaterTile implements Tile {
    public String type = "Water";

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
