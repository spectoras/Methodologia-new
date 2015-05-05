package gr.teicm.game.exception;

public class InvalidCommandArgumentException extends RuntimeException {
    public InvalidCommandArgumentException() {
        super();
    }

    public InvalidCommandArgumentException(String message) {
        super(message);
    }
}
