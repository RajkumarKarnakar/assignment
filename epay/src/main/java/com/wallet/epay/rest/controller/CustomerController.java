package com.wallet.epay.rest.controller;

import com.wallet.epay.repo.entities.CustomerEntity;
import com.wallet.epay.services.CustomerService;
import com.wallet.epay.repo.data.models.CustomerModel;
import com.wallet.epay.web.errors.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing customers.
 *
 * Author: Rajkumar Karnakar
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Registers a new customer.
     *
     * @param customerModel the customer details
     * @return the created CustomerEntity
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerEntity registerCustomer(@RequestBody CustomerModel customerModel) {
        return customerService.createNewCustomer(customerModel);
    }

    /**
     * Retrieves a customer by their unique ID.
     *
     * @param mobile the unique ID of the customer
     * @return ResponseEntity with the CustomerEntity and HTTP status
     */
    @GetMapping("/{mobile}")
    public ResponseEntity<CustomerEntity> getCustomerByUniqueId(@PathVariable("mobile") String mobile) {
        CustomerEntity customer = customerService.getCustomerByMobile(mobile);
        if (customer == null) {
            throw new NotFoundException("Customer with mobile number " + mobile + " not found.");
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
