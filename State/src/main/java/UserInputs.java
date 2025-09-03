import java.util.Scanner;

public class UserInputs {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readUserInput(String[] options) {
        System.out.println("Choose your action:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + " " + options[i - 1]);
        }
        System.out.print("\nEnter: ");
        return scanner.nextInt();
    }
}
