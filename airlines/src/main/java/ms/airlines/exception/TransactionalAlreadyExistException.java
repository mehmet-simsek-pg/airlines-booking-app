package ms.airlines.exception;

public class TransactionalAlreadyExistException extends RuntimeException {
    public TransactionalAlreadyExistException(String message) {
        super(message);
    }
}
