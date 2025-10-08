package Commands;

import MVC.Model;

public class MoveCursorDownCommand implements Command{
    private final Model model;

    public MoveCursorDownCommand(Model model) {
        this.model = model;
    }


    @Override
    public void execute() {
        int newRow = model.getCursorRow() + 1;

        if (newRow < model.getSize()) model.setCursor(newRow, model.getCursorCol());
    }
}
