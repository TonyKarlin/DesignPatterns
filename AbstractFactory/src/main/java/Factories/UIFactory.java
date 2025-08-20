package Factories;

import Interfaces.Button;
import Interfaces.Checkbox;
import Interfaces.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract Checkbox createCheckbox(String text);
    public abstract TextField createTextField(String text);
}
