package Factories;

import B_Components.*;
import Interfaces.*;

public class AppleFactory extends UIFactory{
    @Override
    public Button createButton(String text) {
        return new AppleButton();
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new AppleCheckbox();
    }

    @Override
    public TextField createTextField(String text) {
        return new AppleTextField();
    }

}
