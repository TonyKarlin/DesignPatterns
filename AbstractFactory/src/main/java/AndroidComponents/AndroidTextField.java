package AndroidComponents;

import Interfaces.TextField;

public class AndroidTextField implements TextField {
    @Override
    public void display() {
        System.out.println("TextField: Android");
        String contents = "| > " + "                  " + " |";

        for (int i = 0;i <= 2; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < contents.length(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            } else {
                System.out.println(contents);
            }
        }

    }

    public static void main(String[] args) {
        AndroidTextField field = new AndroidTextField();
        field.display();
    }
}
