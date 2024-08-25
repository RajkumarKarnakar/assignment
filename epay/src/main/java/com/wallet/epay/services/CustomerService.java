package com.wallet.epay.services;

import com.wallet.epay.repo.entities.CustomerEntity;
import com.wallet.epay.repo.entities.UserEntity;
import com.wallet.epay.web.errors.BadRequestException;
import com.wallet.epay.web.dao.CustomerDao;
import com.wallet.epay.web.dao.UserDao;
import com.wallet.epay.repo.data.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for managing customer operations.
 *
 * Author: Rajkumar Karnakar
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private UserDao userDao;

    /**
     * Creates a new customer.
     *
     * @param model the customer details
     * @return the created CustomerEntity
     * @throws BadRequestException if the email or mobile number is already registered, or if the user does not exist or already has an account
     */
    public CustomerEntity createNewCustomer(CustomerModel model) {
        if (getCustomerByMobile(model.getPhone()) == null && getCustomerByEmail(model.getEmail()) == null) {

            CustomerEntity newCustomer = new CustomerEntity();
            newCustomer.setFirstName(model.getFirstName());
            newCustomer.setLastName(model.getLastName());
            newCustomer.setEmail(model.getEmail());
            newCustomer.setPhone(model.getPhone());
            newCustomer.setCity(model.getCity());

            UserEntity user = userDao.findByUserId(model.getUsername());
            if (user == null) {
                throw new BadRequestException("Create a user account first");
            }
            if (user.isHasAccount()) {
                throw new BadRequestException("User already has an account");
            }
            user.setHasAccount(true);
            newCustomer.setUser(user);

            return customerDao.save(newCustomer);
        } else {
            throw new BadRequestException("Email or mobile number already registered");
        }
    }

    /**
     * Retrieves a customer by their mobile number.
     *
     * @param number the mobile number
     * @return the CustomerEntity
     */
    public CustomerEntity getCustomerByMobile(String number) {
        return customerDao.findByPhone(number);
    }

    /**
     * Retrieves a customer by their email.
     *
     * @param email the email address
     * @return the CustomerEntity
     */
    public CustomerEntity getCustomerByEmail(String email) {
        return customerDao.findByEmail(email);
    }
}
