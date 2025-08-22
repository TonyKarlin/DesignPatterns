package AppleComponents;

import Interfaces.Button;

public class AppleButton implements Button {
    String type = "Apple";
    String text;

    public AppleButton(String text) {
        this.text = text;
    }

    private String getType() {
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
