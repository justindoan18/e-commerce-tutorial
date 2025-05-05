package com.hoangdm.customer.services;

import com.hoangdm.customer.exceptions.CustomerNotFoundException;
import com.hoangdm.customer.models.dtos.CustomerMapper;
import com.hoangdm.customer.models.dtos.request.CustomerRequestDTO;
import com.hoangdm.customer.models.dtos.response.CustomerResponseDTO;
import com.hoangdm.customer.models.entities.Customer;
import com.hoangdm.customer.repositories.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(@Valid CustomerRequestDTO request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequestDTO request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())
                ));

        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, @Valid CustomerRequestDTO request) {
        if (StringUtils.isBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponseDTO> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponseDTO findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot find customer with the provided ID:: %s", customerId)
                ));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
