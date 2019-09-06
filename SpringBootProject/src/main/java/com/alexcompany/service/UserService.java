package com.alexcompany.service;

import com.alexcompany.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by User on 17.07.2019.
 */
public interface UserService {

    void save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    List<User> findAll();
    Page<User> findAll(Pageable pageable);


}
