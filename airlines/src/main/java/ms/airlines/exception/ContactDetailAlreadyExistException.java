package ms.airlines.exception;

public class ContactDetailAlreadyExistException extends RuntimeException {
    public ContactDetailAlreadyExistException(String message) {
        super(message);
    }
}
