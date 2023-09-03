package ms.airlines.dto.converter;


import ms.airlines.dto.AirFareDto;
import ms.airlines.model.AirFare;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirFareDtoConverter {
    public AirFareDto convert(AirFare from) {
        return new AirFareDto(
                from.getId(),
                from.getFare(),
                from.getRoute() != null ? from.getRoute().getId() : null
        );
    }

    public List<AirFareDto> convert(List<AirFare> from) {
        return from.stream().map(this::convert).toList();
    }
}
