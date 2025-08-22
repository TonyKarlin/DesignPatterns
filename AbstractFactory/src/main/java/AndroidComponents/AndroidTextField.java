package AndroidComponents;

import Interfaces.TextField;

public class AndroidTextField implements TextField {
    @Override
    public void display(String text) {
        System.out.println("TextField: Android");
        String contents = "| > " + text + " |";

        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < contents.length(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            } else System.out.println(contents);
        }
    }
}

