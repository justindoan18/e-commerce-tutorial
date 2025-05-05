package com.hoangdm.customer.models.dtos.request;

import com.hoangdm.customer.models.entities.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
public record CustomerRequestDTO(
    String id,
    @NotNull(message = "Customer firstname is required")
    String firstname,
    @NotNull(message = "Customer lastname is required")
    String lastname,
    @NotNull(message = "Customer email is required")
    @Email(message = "Not a valid email address")
    String email,
    Address address
) {
}
