package ms.airlines.exception;

public class FlightScheduleNotFoundException extends RuntimeException {
    public FlightScheduleNotFoundException(String message) {
        super(message);
    }
}
