package FeedbackHandlers;

import Messages.Message;
import Messages.MessageType;

public class ContactHandler extends Handler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.CONTACT) {
            System.out.println("\nContact request by: " + message.getEmail() + "\n");
            System.out.println(message.getContent() + "\n");
            System.out.println("We will contact you as soon as we can. Wait time is between 5-10 minutes.");
        } else super.handleNextHandler(message);
    }
}
