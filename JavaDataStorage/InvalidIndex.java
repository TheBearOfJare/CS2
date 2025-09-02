public class InvalidIndex extends Exception {

    public InvalidIndex() {
        super("An unknown error has occured");
    }

    public InvalidIndex (String message) {
        super(message);
    }

    public InvalidIndex(Throwable t) {
        super(t);
    }
    public InvalidIndex(String message, Throwable t) {
        super(message, t);
    }

    
}
