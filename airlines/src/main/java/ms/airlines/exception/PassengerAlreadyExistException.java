package ms.airlines.exception;

public class PassengerAlreadyExistException extends RuntimeException {
    public PassengerAlreadyExistException(String message) {
        super(message);
    }
}
