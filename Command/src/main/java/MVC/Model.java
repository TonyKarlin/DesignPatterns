package MVC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {
    private final int size;
    private final boolean[][] pixels;
    private int cursorRow = 0;
    private int cursorCol = 0;

    private final List<PixelChangeListener> listeners = new ArrayList<>();

    public Model(int size) {
        this.size = size;
        this.pixels = new boolean[size][size];
    }

    public void addListener(PixelChangeListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners(int row, int col) {
        for (PixelChangeListener listener : listeners) {
            listener.onPixelChanged(row, col);
        }
    }

    public void togglePixel(int row, int col) {
        pixels[row][col] = !pixels[row][col];
        notifyListeners(row, col);
    }

    public int getSize() {
        return size;
    }

    public boolean getPixel(int row, int col) {
        return pixels[row][col];
    }

    public void setPixel(int row, int col, boolean value) {
        pixels[row][col] = value;
    }

    public boolean[][] getPixels() {
        return pixels;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void setCursor(int row, int col) {
        this.cursorRow = row;
        this.cursorCol = col;
    }
}
