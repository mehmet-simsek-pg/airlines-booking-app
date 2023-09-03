package ms.airlines.exception;

public class AirFareNotFoundException extends RuntimeException {
    public AirFareNotFoundException(String message) {
        super(message);
    }
}
