package ms.airlines.dto.converter;

import ms.airlines.dto.CountryDto;
import ms.airlines.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDtoConverter {
    public CountryDto convert(Country from) {
        return new CountryDto(
                from.getId(),
                from.getName()
        );
    }

    public List<CountryDto> convert(List<Country> from) {
        return from.stream().map(this::convert).toList();
    }
}
