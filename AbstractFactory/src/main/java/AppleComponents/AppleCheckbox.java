package AppleComponents;

import Interfaces.AbstractUIElements;
import Interfaces.Brand;
import Interfaces.Checkbox;

public class AppleCheckbox extends AbstractUIElements implements Checkbox {
    private final Brand type = Brand.APPLE;

    public AppleCheckbox(String text) {
        this.text = text;
    }

    private Brand getType() {
        return type;
    }

    @Override
    public void display() {
        System.out.println("Checkbox: " + getType());
        String contents = "| " + text + " |";

        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                System.out.print("x");
                for (int j = 0; j < contents.length() - 1; j++) {
                    System.out.print("-");
                }
                System.out.println("x");
            } else {
                System.out.println(contents);
            }
        }
    }
}
