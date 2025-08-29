import Abstractions.Printer;

public class Main {
    public static void main(String[] args) {
        Printer printer1, printer2;

        printer1 = new BasicPrinter();
        printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));

        printer1.print("Does this work?");

        printer2.print("Encrypting!");

        // Couldn't figure a way to decrypt without using this "cheat" way.
        // Definitely wouldn't be the way when working with actual encrypting,
        // but didn't want to spend too much time on the assignment when it was otherwise done.
        String message = ((EncryptedPrinter) printer2).decryptStoredMessage();
        System.out.println("Decrypted message: " + message);

    }
}
