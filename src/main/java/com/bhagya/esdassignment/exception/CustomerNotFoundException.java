package com.bhagya.esdassignment.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String msg;
}
