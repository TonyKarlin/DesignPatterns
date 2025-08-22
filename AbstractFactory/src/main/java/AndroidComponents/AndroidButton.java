package AndroidComponents;
import Interfaces.AbstractUIElements;
import Interfaces.Brand;
import Interfaces.Button;

public class AndroidButton extends AbstractUIElements implements Button {
    private final Brand type = Brand.ANDROID;

    public AndroidButton(String text) {
        this.text = text;
    }

    private Brand getType() {
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
