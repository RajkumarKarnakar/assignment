package com.wallet.epay.repo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for Bank Account.
 * <p>
 * Author: Rajkumar Karnakar
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountModel {

    @NotBlank(message = "Account number is mandatory")
    @Pattern(regexp = "^[0-9]{9,18}$", message = "Account number must be between 9 and 18 digits")
    private long accountNumber;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobile;

    @NotBlank(message = "IFSC code is mandatory")
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "IFSC code must be 11 characters long, starting with 4 letters, followed by 0, and ending with 6 alphanumeric characters")
    private String ifscCode;

    @NotBlank(message = "Bank name is mandatory")
    @Size(min = 2, max = 50, message = "Bank name must be between 2 and 50 characters")
    private String bankName;

}