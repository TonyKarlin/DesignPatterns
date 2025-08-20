package A_Components;

import Interfaces.TextField;

public class AndroidTextField implements TextField {
    @Override
    public void display() {
        System.out.println("TextField: Android");
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) System.out.println("------------------------");
            else if (i == 1) System.out.println("| > " + "                  " + " |");
        }

    }

    public static void main(String[] args) {
        AndroidTextField field = new AndroidTextField();
        field.display();
    }
}
