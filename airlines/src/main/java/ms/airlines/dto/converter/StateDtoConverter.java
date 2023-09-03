package ms.airlines.dto.converter;

import ms.airlines.dto.StateDto;
import ms.airlines.model.State;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StateDtoConverter {
    private final StateCountryDtoConverter stateCountryDtoConverter;

    public StateDtoConverter(StateCountryDtoConverter stateCountryDtoConverter) {
        this.stateCountryDtoConverter = stateCountryDtoConverter;
    }

    public StateDto convert(State from) {
        return new StateDto(
                from.getId(),
                from.getName(),
                from.getCountry() != null ? stateCountryDtoConverter.convert(from.getCountry()) : null
        );
    }

    public List<StateDto> convert(List<State> from) {
        return from.stream().map(this::convert).toList();
    }
}
