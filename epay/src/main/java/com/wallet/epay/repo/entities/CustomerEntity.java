package com.wallet.epay.repo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

/**
 * Entity class for Customer.
 *
 * Author: Rajkumar Karnakar
 *
 * This class represents a Customer entity in the e-wallet system.
 * It includes details such as first name, last name, email, phone, city, KYC status, and the associated user account.
 */
@Entity
@Table(name = "customer")
@Data
@ToString
public class CustomerEntity {

    /**
     * Unique identifier for the customer.
     */
    @Id
    @Column(name = "cin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * First name of the customer.
     */
    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    /**
     * Last name of the customer.
     */
    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    /**
     * Email address of the customer.
     */
    @Column(name = "email")
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    /**
     * Phone number of the customer.
     */
    @Column(name = "phone")
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number should be 10 digits")
    private String phone;

    /**
     * City where the customer resides.
     */
    @Column(name = "city")
    @NotBlank(message = "City cannot be blank")
    private String city;

    /**
     * KYC verification status of the customer.
     */
    @Column(name = "kyc_verify")
    private boolean kycStatus;

    /**
     * The user account associated with this customer.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity user;
}
