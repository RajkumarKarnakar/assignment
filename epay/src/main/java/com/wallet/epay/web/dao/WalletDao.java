package com.wallet.epay.web.dao;

import com.wallet.epay.repo.entities.CustomerEntity;
import com.wallet.epay.repo.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Wallet operations.
 *
 * Author: Rajkumar Karnakar
 */
@Repository
public interface WalletDao extends JpaRepository<WalletEntity, Long> {
    WalletEntity findByCustomer(CustomerEntity customer);
}
