package com.bhagya.esdassignment.mapper;

import com.bhagya.esdassignment.dto.CustomerRequest;
import com.bhagya.esdassignment.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }
}
