import Abstractions.Printer;
import Abstractions.PrinterDecorator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class EncryptedPrinter extends PrinterDecorator {
    Cipher deCipher;
    SecretKey key;
    String encryptedMessage;


    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    private void generateKey() {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            this.key = keygen.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String encrypt(String message) {
        generateKey();
        try {
            deCipher = Cipher.getInstance("DES");
            byte[] text = message.getBytes(StandardCharsets.UTF_8);

            deCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedText = deCipher.doFinal(text);

            return encryptedMessage = new String(encryptedText, StandardCharsets.ISO_8859_1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String encryptedMessage) {
        try {
            deCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = encryptedMessage.getBytes(StandardCharsets.ISO_8859_1);
            byte[] decryptedText = deCipher.doFinal(encryptedText);

            return new String(decryptedText, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decryptStoredMessage() {
        if (encryptedMessage != null && key != null) {
            return decrypt(encryptedMessage);
        }
        throw new IllegalStateException("No encrypted message or key available for decryption.");
    }

    @Override
    public void print(String message) {
        super.print(encrypt(message));
    }
}
