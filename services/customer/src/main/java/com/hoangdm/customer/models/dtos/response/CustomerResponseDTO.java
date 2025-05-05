package com.hoangdm.customer.models.dtos.response;

import com.hoangdm.customer.models.entities.Address;

public record CustomerResponseDTO(
        String id,
        String fisrtname,
        String lastname,
        String email,
        Address address
) {
}
