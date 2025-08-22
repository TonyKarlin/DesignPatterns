package Factories;
import AndroidComponents.*;
import Interfaces.*;

public class AndroidFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new AndroidButton();
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new AndroidCheckbox();
    }

    @Override
    public TextField createTextField(String text) {
        return new AndroidTextField();
    }
}
