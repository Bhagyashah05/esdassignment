package com.bhagya.esdassignment.controller;


import com.bhagya.esdassignment.dto.CustomerRequest;
import com.bhagya.esdassignment.dto.CustomerResponse;
import com.bhagya.esdassignment.dto.UpdateCustomerRequest;
import com.bhagya.esdassignment.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String email) {
        customerService.deleteCustomer(email);
        return ResponseEntity.ok("Customer with email " + email + " deleted successfully");
    }

    @PutMapping("/{email}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable String email,
            @RequestBody @Valid UpdateCustomerRequest request) {
        CustomerResponse updatedCustomer = customerService.updateCustomer(email, request);
        return ResponseEntity.ok(updatedCustomer);
    }
}
