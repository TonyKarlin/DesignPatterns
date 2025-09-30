package Flyweight;

import javafx.scene.image.Image;


public class TileImage implements Flyweight {
    private final Image image;
    private final String description;

    public TileImage(String path, String description) {
        this.image = new Image(path);
        this.description = description;
    }


    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
