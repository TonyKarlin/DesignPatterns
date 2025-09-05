import FeedbackHandlers.*;
import Messages.Message;
import Messages.MessageType;

public class Main {
    public static void main(String[] args) {

        Handler primaryHandler;

        Handler general = new GeneralHandler();
        Handler contact = new ContactHandler();
        Handler dev = new DevelopmentHandler();
        Handler comp = new CompensationHandler();

        comp.setNextHandler(dev);
        dev.setNextHandler(contact);
        contact.setNextHandler(general);

        primaryHandler = comp;

        // The primary way of using the program with user inputs.
        /*Message userFeedback = new Message();
        userFeedback.sendMessage();
        primaryHandler.handleFeedback(userFeedback);*/

        // Main program following the assignment
        Message feedback1 = new Message();
        feedback1.setEmail("user1@example.com");
        feedback1.setType(MessageType.CONTACT);
        feedback1.setContent("I need help with my account.");

        Message feedback2 = new Message();
        feedback2.setEmail("user2@example.com");
        feedback2.setType(MessageType.DEVELOPMENT);
        feedback2.setContent("I have a suggestion for a new feature.");

        Message feedback3 = new Message();
        feedback3.setEmail("user3@example.com");
        feedback3.setType(MessageType.COMPENSATION);
        feedback3.setContent("I would like to request compensation for a service issue.");

        Message feedback4 = new Message();
        feedback4.setEmail("user4@example.com");
        feedback4.setType(MessageType.GENERAL);
        feedback4.setContent("Just wanted to say thank you for the great service!");

        // Sending feedback to the handler chain
        System.out.println("Processing feedback 1:");
        primaryHandler.handleFeedback(feedback1);

        System.out.println("\nProcessing feedback 2:");
        primaryHandler.handleFeedback(feedback2);

        System.out.println("\nProcessing feedback 3:");
        primaryHandler.handleFeedback(feedback3);

        System.out.println("\nProcessing feedback 4:");
        primaryHandler.handleFeedback(feedback4);
    }
}
