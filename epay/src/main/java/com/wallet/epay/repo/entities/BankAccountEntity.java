package com.wallet.epay.repo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Entity class for Bank Account.
 *
 * Author: Rajkumar Karnakar
 *
 * This class represents a Bank Account entity in the e-wallet system.
 * It includes details such as account number, account holder's name, IFSC code, bank name, and the associated customer.
 */
@Entity
@Table(name = "bank_account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BankAccountEntity {

    /**
     * Unique identifier for the bank account.
     */
    @Id
    @Column(name = "sr_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @org.springframework.data.annotation.Transient
    private long id;

    /**
     * Bank account number.
     */
    @Column(name = "account_no")
    @NotNull(message = "Account number cannot be null")
    @Min(value = 1000000000L, message = "Account number should be at least 10 digits")
    private long accountNumber;

    /**
     * Name of the bank account holder.
     */
    @Column(name = "bank_account_holder")
    @NotBlank(message = "Account holder's name cannot be blank")
    private String name;

    /**
     * IFSC code of the bank.
     */
    @Column(name = "ifsc_code", length = 11)
    @NotBlank(message = "IFSC code cannot be blank")
    @Size(min = 11, max = 11, message = "IFSC code must be exactly 11 characters")
    private String ifscCode;

    /**
     * Name of the bank.
     */
    @Column(name = "bank_name")
    @NotBlank(message = "Bank name cannot be blank")
    private String bankName;

    /**
     * The customer associated with this bank account.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;
}
