package Commands;

import MVC.Model;

public class MoveCursorLeftCommand implements Command{
    private final Model model;

    public MoveCursorLeftCommand(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        int newCol = model.getCursorCol() - 1;

        if (newCol >= 0) model.setCursor(model.getCursorRow(), newCol);
    }
}
