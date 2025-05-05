package com.hoangdm.customer.models.dtos;

import com.hoangdm.customer.models.dtos.request.CustomerRequestDTO;
import com.hoangdm.customer.models.dtos.response.CustomerResponseDTO;
import com.hoangdm.customer.models.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequestDTO request) {
        if (request == null) return null;

        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponseDTO fromCustomer(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
