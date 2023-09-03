package ms.airlines.dto.converter;

import ms.airlines.dto.AirCraftDto;
import ms.airlines.model.AirCraft;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirCraftDtoConverter {
    public AirCraftDto convert(AirCraft from) {
        return new AirCraftDto(
                from.getId(),
                from.getNumber(),
                from.getCapacity(),
                from.getManufacturer(),
                from.getManufactureDate(),
                from.getFlightSchedule() != null ? from.getFlightSchedule().getId() : null
        );
    }

    public List<AirCraftDto> convert(List<AirCraft> from) {
        return from.stream().map(this::convert).toList();
    }
}
