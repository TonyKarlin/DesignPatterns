package MVC;

// A light Observer pattern
// Implemented in Model class
@FunctionalInterface
public interface PixelChangeListener {
    void onPixelChanged(int row, int col);
}
