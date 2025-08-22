package Interfaces;

public abstract class AbstractUIElements implements UIElement {
    protected String text;

    @Override
    public void setText(String newText) {
        this.text = newText;
    }
}
