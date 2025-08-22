package Factories;
import AndroidComponents.*;
import Interfaces.*;

public class AndroidFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new AndroidButton(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new AndroidCheckbox(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new AndroidTextField(text);
    }
}
