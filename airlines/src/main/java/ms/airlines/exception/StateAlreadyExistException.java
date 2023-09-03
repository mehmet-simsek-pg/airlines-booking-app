package ms.airlines.exception;

public class StateAlreadyExistException extends RuntimeException {
    public StateAlreadyExistException(String message) {
        super(message);
    }
}
