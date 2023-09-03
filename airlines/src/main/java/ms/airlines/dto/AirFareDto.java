package ms.airlines.dto;

public record AirFareDto(
        String id,
        Double fare,
        String routeId
) {
}
