package Factory.Tiles;

public class BuildingTile implements Tile{
    public String type = "Building";


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
