package ms.airlines.exception;

public class RouteAlreadyExistException extends RuntimeException {
    public RouteAlreadyExistException(String message) {
        super(message);
    }
}
