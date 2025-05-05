package com.hoangdm.product.models.dtos;

import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double availableQuantity,
        BigDecimal price,
        CategoryResponse category
) {
}
