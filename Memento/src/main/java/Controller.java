

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> undoHistory; // Memento history
    private List<IMemento> redoHistory; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.undoHistory = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToUndo();
        clearRedo();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToUndo();
        clearRedo();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void restoreStateFromHistory(IMemento memento) {
        saveToRedo();
        model.restoreState(memento);
        gui.updateGui();
    }


    public void undo() {
        if (!undoHistory.isEmpty()) {
            System.out.println("Memento found in history");
            saveToRedo();
            IMemento previousState = undoHistory.removeLast();
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            saveToUndo();
            IMemento nextState = redoHistory.removeLast();
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToUndo() {
        IMemento currentState = model.createMemento();
        if (undoHistory.size() >= 10) {
            undoHistory.removeFirst();
        }
        undoHistory.add(currentState);
    }

    private void saveToRedo() {
        IMemento currentState = model.createMemento();
        redoHistory.add(currentState);
    }

    private void clearRedo() {
        redoHistory.clear();
    }

    public List<IMemento> getUndoHistory() {
        return undoHistory;
    }
}