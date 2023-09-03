package ms.airlines.dto;

public record PassengerContactDetailDto(
        String id,
        String email,
        String phone,
        String street,
        String stateId
) {
}
