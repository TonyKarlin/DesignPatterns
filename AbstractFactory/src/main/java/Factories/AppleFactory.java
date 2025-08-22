package Factories;

import AppleComponents.*;
import Interfaces.*;

public class AppleFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new AppleButton(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new AppleCheckbox(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new AppleTextField(text);
    }

}
