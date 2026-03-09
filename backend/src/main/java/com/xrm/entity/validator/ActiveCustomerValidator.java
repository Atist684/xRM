package com.xrm.entity.validator;

import com.xrm.entity.Customer;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ActiveCustomerValidator implements ConstraintValidator<ActiveCustomer, Customer> {

    @Override
    public boolean isValid(Customer customer, ConstraintValidatorContext context) {
        if (customer == null) {
            return false; 
        }
        return customer.getStatus().isActive();
    }
} 
