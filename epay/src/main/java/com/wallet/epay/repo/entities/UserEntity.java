package com.wallet.epay.repo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Entity class for User.
 *
 * Author: Rajkumar Karnakar
 *
 * This class represents a User entity in the e-wallet system.
 * It includes details such as user ID, password, role, and account status.
 */
@Entity
@Table(name = "user")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    /**
     * Enum representing the different roles a user can have.
     */
    public enum Role {
        ANALYTIC, ADMIN, BASIC, SUPER,
    }

    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Unique user ID.
     */
    @Column(name = "user_id")
    @NotBlank(message = "User ID cannot be blank")
    private String userId;

    /**
     * Password for the user account.
     */
    @Column(name = "password")
    @NotBlank(message = "Password cannot be blank")
    private String password;

    /**
     * Role of the user.
     */
    @Column(name = "role")
    @NotNull(message = "Role cannot be null")
    private Role role;

    /**
     * Status of the user account (active/inactive).
     */
    @Column(name = "account_status")
    private boolean hasAccount;
}
