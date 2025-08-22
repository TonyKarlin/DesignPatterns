package AppleComponents;

import Interfaces.TextField;

public class AppleTextField implements TextField {
    String type = "Apple";
    String text;

    public AppleTextField(String text) {
        this.text = text;
    }

    private String getType() {
        return type;
    }

    @Override
    public void display() {
        System.out.println("TextField: " + getType());
        String contents = "| > " + text + " < |";

        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < contents.length(); j++) {
                    if (j == 0 || j == contents.length() - 1) {
                        System.out.print("x");
                        continue;
                    }
                    System.out.print("-");
                }
                System.out.println();
            } else System.out.println(contents);
        }
    }
}
