package ms.airlines.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ms.airlines.helper.messages.ValidationMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePassengerRequest {

    @NotEmpty(message = ValidationMessage.Passenger.FIRST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Passenger.FIRST_NAME_NOT_NULL)
    private String firstName;

    @NotEmpty(message = ValidationMessage.Passenger.LAST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Passenger.LAST_NAME_NOT_NULL)
    private String lastName;

    @NotEmpty(message = ValidationMessage.Passenger.ADDRESS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Passenger.ADDRESS_NOT_NULL)
    private String address;

    @NotNull(message = ValidationMessage.Passenger.AGE_NOT_NULL)
    private Integer age;

    @NotEmpty(message = ValidationMessage.Passenger.NATIONALITY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Passenger.NATIONALITY_NOT_NULL)
    private String nationality;
}
