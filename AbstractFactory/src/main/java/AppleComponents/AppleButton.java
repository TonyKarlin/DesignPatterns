package AppleComponents;

import Interfaces.AbstractUIElements;
import Interfaces.Brand;
import Interfaces.Button;

public class AppleButton extends AbstractUIElements implements Button {
    private final Brand type = Brand.APPLE;

    public AppleButton(String text) {
        this.text = text;
    }

    private Brand getType() {
        return type;
    }

    @Override
    public void display() {
        System.out.println("Button: " + getType());
        String contents = "|< " + text + " >|";
        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                System.out.print("x");
                for (int j = 0; j < contents.length() - 2; j++) {
                    System.out.print("-");
                }
                System.out.println("x");
            } else System.out.println(contents);
        }
    }
}
