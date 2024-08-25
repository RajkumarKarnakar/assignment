package com.wallet.epay.repo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Rajkumar Karnakar
 *
 * This class represents a Wallet entity in the e-wallet system.
 * It includes details such as wallet ID, status, balance, and the associated customer.
 */
@Entity
@Table(name = "wallet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity {

    /**
     * Unique identifier for the wallet.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Unique wallet ID.
     */
    @Column(name = "wallet_id")
    @NotBlank(message = "Wallet ID cannot be blank")
    private String walletId;

    /**
     * Status of the wallet (active/inactive).
     */
    @Column(name = "status")
    private boolean active;

    /**
     * Current balance in the wallet.
     */
    @Column(name = "balance")
    @PositiveOrZero(message = "Balance must be zero or positive")
    private double balance;

    /**
     * The customer to whom this wallet belongs.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerEntity customer;
}
