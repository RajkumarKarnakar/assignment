package com.wallet.epay.services;

import com.wallet.epay.repo.entities.UserEntity;
import com.wallet.epay.web.errors.BadRequestException;
import com.wallet.epay.web.dao.UserDao;
import com.wallet.epay.repo.data.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for managing user operations.
 * <p>
 * Author: Rajkumar Karnakar
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Creates a new user.
     *
     * @param model the user details
     * @return the created UserModel with masked password
     * @throws BadRequestException if the username already exists
     */
    public UserModel createNewUser(UserModel model) {
        if (userDao.findByUserId(model.getUsername()) == null) {
            UserEntity newUser = new UserEntity();
            newUser.setUserId(model.getUsername());
            newUser.setPassword(model.getPassword()); // Ensure to hash the password before saving
            newUser.setHasAccount(false);
            newUser.setRole(UserEntity.Role.BASIC);
            userDao.save(newUser);

            // Mask the password in the response model
            model.setPassword("********");
            return model;
        } else {
            throw new BadRequestException("User with this username already exists");
        }
    }
}
