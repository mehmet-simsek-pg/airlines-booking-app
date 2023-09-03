package ms.airlines.exception;

public class FlightScheduleAlreadyExistException extends RuntimeException {
    public FlightScheduleAlreadyExistException(String message) {
        super(message);
    }
}
