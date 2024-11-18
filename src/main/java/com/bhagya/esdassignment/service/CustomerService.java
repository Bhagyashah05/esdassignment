package com.bhagya.esdassignment.service;

import com.bhagya.esdassignment.dto.CustomerRequest;
import com.bhagya.esdassignment.dto.LoginRequest;
import com.bhagya.esdassignment.entity.Customer;
import com.bhagya.esdassignment.exception.CustomerNotFoundException;
import com.bhagya.esdassignment.helper.EncryptionService;
import com.bhagya.esdassignment.helper.JWTHelper;
import com.bhagya.esdassignment.mapper.CustomerMapper;
import com.bhagya.esdassignment.repo.CustomerRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor

public class CustomerService {
    private final CustomerRepo customerRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    private final CustomerMapper customerMapper;


    public Customer getCustomer(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update Customer:: No customer found with the provided ID:: %s", email)
                ));
    }
    public String login(LoginRequest request) {

            Customer customer = getCustomer(request.email());
            if(!encryptionService.validates(request.password(), customer.getPassword())) {
                return "Wrong Password or Email";
            }

            return jwtHelper.generateToken(request.email());
    }

    public String createCustomer(@Valid CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        customerRepo.save(customer);
        return "Customer Created Successfully";

    }
}
