package ms.airlines.exception;

public class ContactDetailNotFoundException extends RuntimeException {
    public ContactDetailNotFoundException(String message) {
        super(message);
    }
}
