package ms.airlines.dto.converter;

import ms.airlines.dto.RouteAirFareDto;
import ms.airlines.model.AirFare;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteAirFareDtoConverter {
    public RouteAirFareDto convert(AirFare from) {
        return new RouteAirFareDto(
                from.getId(),
                from.getFare()
        );
    }

    public List<RouteAirFareDto> convert(List<AirFare> from) {
        return from.stream().map(this::convert).toList();
    }
}
