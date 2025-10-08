package Commands;

import MVC.Model;

public class MovementCommand {
    private final Model model;

    public MovementCommand(Model model) {
        this.model = model;
    }

    public void move(String direction) {
        Command command = switch (direction.toUpperCase()) {
            case "UP" -> new MoveCursorUpCommand(model);
            case "DOWN" -> new MoveCursorDownCommand(model);
            case "LEFT" -> new MoveCursorLeftCommand(model);
            case "RIGHT" -> new MoveCursorRightCommand(model);
            default -> null;
        };

        if (command != null) {
            command.execute();
        }
    }
}
