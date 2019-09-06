package com.alexcompany.repository;

import com.alexcompany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by User on 15.07.2019.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository,
        JpaSpecificationExecutor<User> {
    Optional<User> findByUsername(String username);

}
