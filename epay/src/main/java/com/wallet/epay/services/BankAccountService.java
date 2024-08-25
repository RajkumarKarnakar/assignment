package com.wallet.epay.services;

import com.wallet.epay.repo.entities.BankAccountEntity;
import com.wallet.epay.repo.entities.CustomerEntity;
import com.wallet.epay.repo.entities.WalletEntity;
import com.wallet.epay.web.dao.WalletDao;
import com.wallet.epay.web.errors.BadRequestException;
import com.wallet.epay.web.dao.BankAccountDao;
import com.wallet.epay.web.dao.CustomerDao;
import com.wallet.epay.repo.data.models.BankAccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for managing bank accounts.
 *
 * Author: Rajkumar Karnakar
 */
@Service
public class BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private WalletDao walletDao;

    /**
     * Adds a new bank account to a customer.
     *
     * @param customer the customer entity
     * @param bankAccountModel the bank account details
     * @return the saved BankAccountEntity
     */
    public BankAccountEntity addNewBankAccountToCustomer(CustomerEntity customer, BankAccountModel bankAccountModel) {
        if (customer == null || bankAccountModel == null) {
            throw new BadRequestException("Customer or BankAccountModel cannot be null");
        }

        BankAccountEntity bankAccount = new BankAccountEntity();
        bankAccount.setAccountNumber(bankAccountModel.getAccountNumber());
        bankAccount.setName(bankAccountModel.getName());
        bankAccount.setIfscCode(bankAccountModel.getIfscCode());
        bankAccount.setBankName(bankAccountModel.getBankName());
        bankAccount.setCustomer(customer);

        WalletEntity wallet = new WalletEntity();
        wallet.setWalletId(bankAccountModel.getMobile());
        wallet.setActive(true);
        wallet.setBalance(0);
        wallet.setCustomer(customer);
        walletDao.save(wallet);

        return bankAccountDao.save(bankAccount);
    }
}
