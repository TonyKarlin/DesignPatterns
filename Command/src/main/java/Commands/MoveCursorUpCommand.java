package Commands;

import MVC.Model;

public class MoveCursorUpCommand implements Command{
    private final Model model;

    public MoveCursorUpCommand(Model model) {
        this.model = model;
    }


    @Override
    public void execute() {
        int newRow = model.getCursorRow() - 1;

        if (newRow >= 0) model.setCursor(newRow, model.getCursorCol());
    }
}
