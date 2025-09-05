package FeedbackHandlers;

import Messages.*;

public class DevelopmentHandler extends Handler {
    @Override
    public void handleFeedback(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT) {
            System.out.println("\nDevelopment Feedback by: " + message.getEmail() + "\n");
            System.out.println(message.getContent() + "\n");
            System.out.println("Thank you for your input on development-related matters.");
            System.out.println("We will review your suggestions and get back to you if necessary.");
        } else super.handleNextHandler(message);
    }
}

