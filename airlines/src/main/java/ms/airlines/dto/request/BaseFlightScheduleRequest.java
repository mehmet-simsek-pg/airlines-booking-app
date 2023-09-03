package ms.airlines.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.airlines.helper.messages.ValidationMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseFlightScheduleRequest {

    @NotEmpty(message = ValidationMessage.FlightSchedule.FLIGHT_DATE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.FlightSchedule.FLIGHT_DATE_NOT_NULL)
    private LocalDate flightDate;

    @NotEmpty(message = ValidationMessage.FlightSchedule.DEPARTURE_DATE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.FlightSchedule.DEPARTURE_DATE_NOT_NULL)
    private LocalDate departure;

    @NotEmpty(message = ValidationMessage.FlightSchedule.ARRIVAL_DATE_NOT_EMPTY)
    @NotNull(message = ValidationMessage.FlightSchedule.ARRIVAL_DATE_NOT_NULL)
    private LocalDate arrival;
}
