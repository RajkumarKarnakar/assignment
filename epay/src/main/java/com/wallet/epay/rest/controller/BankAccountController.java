package com.wallet.epay.rest.controller;

import com.wallet.epay.repo.data.models.BankAccountModel;
import com.wallet.epay.repo.entities.CustomerEntity;
import com.wallet.epay.services.BankAccountService;
import com.wallet.epay.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing bank accounts.
 * Author: Rajkumar Karnakar
 */
@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private CustomerService customerService;

    /**
     * Adds a new bank account to a customer.
     *
     * @param mobile           the mobile number of the customer
     * @param bankAccountModel the bank account details
     * @return ResponseEntity with the bank account model and HTTP status
     */
    @PostMapping("/add/{mobile}")
    public ResponseEntity<BankAccountModel> addNewBankAccount(@PathVariable("mobile") String mobile, @RequestBody BankAccountModel bankAccountModel) {
        CustomerEntity customer = customerService.getCustomerByMobile(mobile);

        if (customer == null) {
            // Return an error response if the customer is not found
            return new ResponseEntity<>(bankAccountModel, HttpStatus.EXPECTATION_FAILED);
        }

        // Add the new bank account to the customer
        bankAccountService.addNewBankAccountToCustomer(customer, bankAccountModel);

        // Return a success response
        return new ResponseEntity<>(bankAccountModel, HttpStatus.ACCEPTED);
    }
}
