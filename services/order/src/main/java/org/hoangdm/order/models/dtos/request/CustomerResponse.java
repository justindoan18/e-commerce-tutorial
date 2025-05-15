package org.hoangdm.order.models.dtos.request;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
