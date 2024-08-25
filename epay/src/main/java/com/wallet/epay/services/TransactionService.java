package com.wallet.epay.services;

import com.wallet.epay.repo.entities.TransactionEntity;
import com.wallet.epay.web.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionDao transactionDao;
    public TransactionEntity getTransactionById(int id){
        return transactionDao.findByTransactionId(id);
    }
}

