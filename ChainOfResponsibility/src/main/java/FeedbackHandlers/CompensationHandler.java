package FeedbackHandlers;

import Messages.Message;
import Messages.MessageType;

public class CompensationHandler extends Handler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.COMPENSATION) {
            System.out.println("\nQuery about Compensations by: " + message.getEmail() + "\n");
            System.out.println(message.getContent() + "\n");
            System.out.println("We will review your query and respond shortly regarding any compensations.");
        } else super.handleNextHandler(message);
    }
}
