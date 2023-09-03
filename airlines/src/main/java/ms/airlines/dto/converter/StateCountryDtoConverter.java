package ms.airlines.dto.converter;

import ms.airlines.dto.StateCountryDto;
import ms.airlines.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateCountryDtoConverter {
    public StateCountryDto convert(Country from) {
        return new StateCountryDto(
                from.getId(),
                from.getName()
        );
    }

    public List<StateCountryDto> convert(List<Country> from) {
        return from.stream().map(this::convert).toList();
    }
}
