package com.wallet.epay.web.dao;

import com.wallet.epay.repo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for User operations.
 *
 * Author: Rajkumar Karnakar
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    /**
     * Finds a user by their user ID.
     *
     * @param userId the user ID
     * @return the UserEntity
     */
    UserEntity findByUserId(String userId);
}
