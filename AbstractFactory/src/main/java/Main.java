import Factories.AndroidFactory;
import Factories.AppleFactory;
import Factories.UIFactory;
import Interfaces.Button;
import Interfaces.Checkbox;
import Interfaces.TextField;

public class Main {
    public static void main(String[] args) {
        UIFactory factory = new AppleFactory();
        TextField field = factory.createTextField("Type here...            ");
        Checkbox box = factory.createCheckbox("\u2705");
        Button btn = factory.createButton("Button");
        field.display();
        box.display();
        btn.display();
        field.setText("Does this work?");
        field.display();
    }
}
