import java.util.Iterator;

// Implements the Iterator interface and its required methods using the FibonacciSequence logic.
// Fibonacci numbers are stored in an array and used in the sequence() method within FibonacciSequence.
// Numbers were stored within variables at first, but I wanted to test it out with the use of arrays and decided
// to keep it like that in the end.
public class FibonacciIterator implements Iterator<Integer> {
    private final FibonacciSequence sequence;
    private int[] data;

    public FibonacciIterator(FibonacciSequence sequence) {
        this.sequence = sequence;
        reset();
    }

    public int getTail() {
        return data[0];
    }

    public int getHead() {
        return data[1];
    }

    // Initialization
    public void reset() {
        this.data = new int[]{1, 1};
    }

    @Override
    public boolean hasNext() {
        return getHead() != 0; // Probably not the best way of doing this, but I wanted it to be true for my while-loop
    }

    @Override
    public Integer next() {
        System.out.println("Current sequence: " +
                getTail() +
                " + " +
                getHead());

        data = sequence.nextSequence(data); // Process the next sequence and store the updated numbers in data array[]

        return getHead(); // returns the new head of the array to display the next number in the sequence
    }
}
