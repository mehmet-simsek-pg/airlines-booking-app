package ms.airlines.exception;

public class AirCraftNotFoundException extends RuntimeException {
    public AirCraftNotFoundException(String message) {
        super(message);
    }
}
