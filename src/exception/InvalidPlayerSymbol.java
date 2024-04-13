package exception;

public class InvalidPlayerSymbol extends RuntimeException{
    public InvalidPlayerSymbol(String message) {
        super(message);
    }
}
