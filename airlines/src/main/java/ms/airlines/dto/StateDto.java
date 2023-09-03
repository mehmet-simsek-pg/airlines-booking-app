package ms.airlines.dto;


public record StateDto(
        String id,
        String name,
        StateCountryDto country
) {
}
