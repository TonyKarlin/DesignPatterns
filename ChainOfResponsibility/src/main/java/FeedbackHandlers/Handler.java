package FeedbackHandlers;

import Messages.Message;

public abstract class Handler {
    private Handler next;

    public void setNextHandler(Handler next) {
        this.next = next;
    }

    public abstract void handleFeedback(Message request);

    protected void handleNextHandler(Message request) {
        if (next != null) {
            next.handleFeedback(request);
        }
    }
}
