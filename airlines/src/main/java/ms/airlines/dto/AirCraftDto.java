package ms.airlines.dto;


import java.time.LocalDate;

public record AirCraftDto(
        String id,
        String number,
        Integer capacity,
        String manufacturer,
        LocalDate manufactureDate,
        String flightScheduleId
) {
}