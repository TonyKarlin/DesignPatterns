package Factory.Tiles;

public class SwampTile implements Tile{
    public String type = "Swamp";

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
