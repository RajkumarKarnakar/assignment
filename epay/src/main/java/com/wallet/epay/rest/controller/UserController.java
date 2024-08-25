package com.wallet.epay.rest.controller;

import com.wallet.epay.services.UserService;
import com.wallet.epay.repo.data.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for managing user operations.
 *
 * Author: Rajkumar Karnakar
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Registers a new user.
     *
     * @param userModel the user details
     * @return ResponseEntity with the created UserModel and HTTP status
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserModel userModel) {
        UserModel createdUser = userService.createNewUser(userModel);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
