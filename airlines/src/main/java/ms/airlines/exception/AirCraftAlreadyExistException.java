package ms.airlines.exception;

public class AirCraftAlreadyExistException extends RuntimeException {
    public AirCraftAlreadyExistException(String message) {
        super(message);
    }
}
