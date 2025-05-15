package org.hoangdm.order.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hoangdm.order.models.dtos.OrderRequest;
import org.hoangdm.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    public ResponseEntity<?> createOrder(
            @RequestBody @Valid OrderRequest request
    ) {
        return ResponseEntity.ok(service.createOrder(request));
    }
}
