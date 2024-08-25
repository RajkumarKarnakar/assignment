package com.wallet.epay.web.dao;

import com.wallet.epay.repo.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Transaction operations.
 *
 * Author: Rajkumar Karnakar
 */
@Repository
public interface TransactionDao extends JpaRepository<TransactionEntity, Long> {
    TransactionEntity findByTransactionId(int id);
}
