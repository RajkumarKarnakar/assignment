package com.wallet.epay.web.dao;

import com.wallet.epay.repo.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Customer operations.
 *
 * Author: Rajkumar Karnakar
 */
@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

    /**
     * Finds a customer by their phone number.
     *
     * @param phone the phone number
     * @return the CustomerEntity
     */
    CustomerEntity findByPhone(String phone);

    /**
     * Finds a customer by their email address.
     *
     * @param email the email address
     * @return the CustomerEntity
     */
    CustomerEntity findByEmail(String email);
}
