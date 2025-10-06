import java.util.Iterator;

public class FibonacciSequence implements Sequence {

    public FibonacciSequence() {
    }

    // FibonacciSequence class only calculates the next number iteration with the given array in params.
    // At first, I stored the tail + head within the class, but realized it stored the iteration.
    // If user wanted to test out the sequence in my Main class, the program would continue using the stored numbers
    // from previous FibonacciSequence. (might have been a design flaw, I'm not 100% sure,
    // but I like the current implementation better)

    public int[] nextSequence(int[] array) {
        int next = array[1] + array[0];
        array[0] = array[1];
        array[1] = next;
        return array;
    }

    // Another way of doing it through recursion, but I think easier to understand and use with the other methods
    public int recursiveSequence(int data) {
        if (data <= 1) {
            return data;
        }
        return (recursiveSequence(data - 1) + recursiveSequence(data - 2));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(this);
    }

    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();

        int i = 1;
        while (i <= 10) {
            int val = sequence.recursiveSequence(i);
            System.out.println("Iteration: " + i + "\nValue: " + val);
            i++;
        }
    }
}
