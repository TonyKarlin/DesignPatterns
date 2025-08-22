package AndroidComponents;

import Interfaces.Checkbox;

public class AndroidCheckbox implements Checkbox {
    @Override
    public void display(String text) {
        System.out.println("Checkbox: Android");
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
