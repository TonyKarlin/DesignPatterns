package Messages;

import java.util.Scanner;

public class Message {
    private static final Scanner scanner = new Scanner(System.in);
    private MessageType type;
    private String content;
    private String email;
    private final int linebreakThreshold = 80;

    public Message() {
    }

    public MessageType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    private void options() {
        System.out.println("Enter message type:\n");
        for (MessageType type : MessageType.values()) {
            System.out.println("- " + type);
        }
        System.out.print("\nChoose: ");
        String result = scanner.nextLine().toUpperCase();
        setTypeDynamically(result);
    }

    private void setTypeDynamically(String type) {
        switch (type) {
            case "GENERAL":
                this.type = MessageType.GENERAL;
                break;
            case "CONTACT":
                this.type = MessageType.CONTACT;
                break;
            case "DEVELOPMENT":
                this.type = MessageType.DEVELOPMENT;
                break;
            case "COMPENSATION":
                this.type = MessageType.COMPENSATION;
                break;
            default:
                System.out.println("Invalid message type!");
                break;
        }
    }

    private String addLinebreak(String message) {
        StringBuilder sb = new StringBuilder(message);
        int i = 0;
        while ((i = sb.indexOf(" ", i + linebreakThreshold)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        return sb.toString();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void enterEmail() {
        System.out.println("Enter your email and we will get back to you as soon as possible.");
        System.out.print("Enter an email address: ");
        setEmail(scanner.nextLine());
    }

    public void sendMessage() {
        options();
        System.out.println("\nEnter your message: ");
        content = scanner.nextLine();
        if (content.length() > linebreakThreshold) {
            content = addLinebreak(content);
        }
        enterEmail();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}

