package com.wallet.epay.web.dao;

import com.wallet.epay.repo.entities.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Bank Account operations.
 *
 * Author: Rajkumar Karnakar
 */
@Repository
public interface BankAccountDao extends JpaRepository<BankAccountEntity, Long> {
}
