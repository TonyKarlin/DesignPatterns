package AndroidComponents;

import Interfaces.Button;

public class AndroidButton implements Button {
    String type = "Android";
    String text;

    public AndroidButton(String text) {
        this.text = text;
    }

    private String getType() {
        return type;
    }

    @Override
    public void display() {
        System.out.println("Button: " + getType());
        String contents = "| " + text + " |";
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
