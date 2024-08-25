package com.wallet.epay.repo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Entity class for Transaction.
 *
 * Author: Rajkumar Karnakar
 *
 * This class represents a Transaction entity in the e-wallet system.
 * It includes details such as transaction ID, date and time, amount, type, and the associated accounts.
 */
@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransactionEntity {

    /**
     * Unique identifier for the transaction.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true, nullable = false, updatable = false)
    private int transactionId;

    /**
     * Date and time of the transaction.
     */
    @Column(name = "transaction_date_time")
    @NotNull(message = "Transaction date and time cannot be null")
    private LocalDateTime dateTime;

    /**
     * Amount involved in the transaction.
     */
    @Column(name = "amount")
    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    private double amount;

    /**
     * Enum representing the type of transaction (DEBIT/CREDIT).
     */
    public enum Type {
        DEBIT, CREDIT
    }

    /**
     * Type of the transaction.
     */
    @Column(name = "type_of_transaction")
    @NotNull(message = "Transaction type cannot be null")
    private Type type;

    /**
     * Account from which the amount is debited.
     */
    @Column(name = "debit_from")
    @NotBlank(message = "Debit account cannot be blank")
    private String debitAccount;

    /**
     * Account to which the amount is credited.
     */
    @Column(name = "credit_to")
    @NotBlank(message = "Credit account cannot be blank")
    private String creditAccount;

    /**
     * The customer associated with this transaction.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;
}
