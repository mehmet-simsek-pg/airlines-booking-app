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
public class BaseCountryRequest {
    @NotEmpty(message = ValidationMessage.Country.NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Country.NAME_NOT_NULL)
    private String name;
}
