package AndroidComponents;

import Interfaces.Button;

public class AndroidButton implements Button {
    @Override
    public void display() {
        System.out.println("Button: Android");
        String contents = "| " + "Button" + " |";
        for (int i = 0; i <= 2; i++) {
            if (i == 0 || i == 2) {
                for (int j = 0; j < contents.length(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            } else System.out.println(contents);
        }
    }

    public static void main(String[] args) {
        AndroidButton button = new AndroidButton();
        button.display();
    }
}
