package Commands;

import MVC.Model;

public class MoveCursorRightCommand implements Command{
    private final Model model;

    public MoveCursorRightCommand(Model model) {
        this.model = model;
    }

    @Override
    public void execute() {
        int newCol = model.getCursorCol() + 1;

        if (newCol < model.getSize()) model.setCursor(model.getCursorRow(), newCol);
    }
}
