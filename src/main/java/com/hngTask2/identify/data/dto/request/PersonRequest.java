package com.hngTask2.identify.data.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.hngTask2.identify.data.model.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static com.hngTask2.identify.utility.IdentifyUtilities.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PersonRequest {

    @NotNull(message = NOT_NULL)
    private String firstName;

    @NotNull(message = NOT_NULL)
    private String lastName;

    private String phoneNumber;

    private Address address;
}
