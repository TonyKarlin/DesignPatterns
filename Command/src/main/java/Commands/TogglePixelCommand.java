package Commands;

import MVC.Model;

public class TogglePixelCommand implements Command{
    private final Model model;
    private final int row, col;

    public TogglePixelCommand(Model model, int row, int col) {
        this.model = model;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        model.togglePixel(row, col);
    }
}
