import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sequence sequence = new FibonacciSequence();
        Iterator<Integer> iterator = sequence.iterator();

        int i = 1;
        // Prints the first 10 Fibonacci numbers
        while (iterator.hasNext()) {
            System.out.println("Results in: " + iterator.next());
            if (i == 10) {
                break;
            }
            i++;

        }

        Iterator<Integer> inputIterator = sequence.iterator();
        System.out.println("\nTry it out for yourself.\n");
        // Lets the User try the sequence out until they decide to quit or
        // probably till the TYPE INT reaches its limits :D
        while (inputIterator.hasNext()) {
            System.out.println("Results in: " + inputIterator.next());
            System.out.println("Input anything to continue or ( q = quit ): ");
            String s = sc.nextLine();
            if (s.equals("q")) {
                break;
            }
        }
        System.out.println("Thank you for trying it out :)");
    }
}
