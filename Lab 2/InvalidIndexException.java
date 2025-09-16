public class InvalidIndexException extends Exception {
    public InvalidIndexException() {
        super("Sorry, pal. That's not going to work for me.");
    }

    public InvalidIndexException(String message) {
        super(message);
    }

    public InvalidIndexException(Throwable t) {
        super(t);
    }

    public InvalidIndexException(String message, Throwable t) {
        super(message, t);
    }
}
