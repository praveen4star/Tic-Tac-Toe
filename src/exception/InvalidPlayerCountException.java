package exception;

public class InvalidPlayerCountException extends RuntimeException{
    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
