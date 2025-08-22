package AndroidComponents;

import Interfaces.Checkbox;

public class AndroidCheckbox implements Checkbox {
    String type = "Android";
    String text;

    public AndroidCheckbox(String text) {
        this.text = text;
    }

    private String getType() {
        return type;
    }

    @Override
    public void display() {
        System.out.println("Checkbox: " + getType());
        String contents = "| " + text + " |";

        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                System.out.print(" -");
                for (int j = 0; j < contents.length() - 2; j++) {
                    System.out.print("-");
                }
                System.out.println();
            } else {
                System.out.println(contents);
            }
        }
    }
}
