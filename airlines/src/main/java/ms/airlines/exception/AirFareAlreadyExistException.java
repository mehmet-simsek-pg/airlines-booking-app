package ms.airlines.exception;

public class AirFareAlreadyExistException extends RuntimeException {
    public AirFareAlreadyExistException(String message) {
        super(message);
    }
}
