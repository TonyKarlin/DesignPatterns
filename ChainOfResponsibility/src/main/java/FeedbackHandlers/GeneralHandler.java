package FeedbackHandlers;

import Messages.Message;
import Messages.MessageType;

public class GeneralHandler extends Handler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.GENERAL) {
            System.out.println("\nGeneral Feedback by: " + message.getEmail() + "\n");
            System.out.println(message.getContent() + "\n");
            System.out.println("Your feedback has been noted!\nWe’ll make sure it’s passed on to the right team.");
        }
    }
}
