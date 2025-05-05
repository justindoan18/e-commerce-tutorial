package com.hoangdm.customer.repositories;

import com.hoangdm.customer.models.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
