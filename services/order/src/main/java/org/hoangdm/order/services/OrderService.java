package org.hoangdm.order.services;

import lombok.RequiredArgsConstructor;
import org.hoangdm.order.exceptions.BusinessException;
import org.hoangdm.order.models.dtos.OrderRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    public Integer createOrder(OrderRequest request) {
        // Check customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer exist with the ID: " + request.customerId()));

        // purchase the product --> product-ms (RestTemplate)


        // persist order

        // persist order lines

        //start payment process

        // send the order confirmation --> notification-ms(kafka)
        return null;
    }
}
