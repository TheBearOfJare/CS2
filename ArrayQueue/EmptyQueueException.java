public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("No data to remove");
    }

    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException(Throwable t) {
        super(t);
    }

    public EmptyQueueException(String message, Throwable t) {
        super(message, t);
    }
}
