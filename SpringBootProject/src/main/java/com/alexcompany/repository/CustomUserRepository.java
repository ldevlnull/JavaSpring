package com.alexcompany.repository;

import com.alexcompany.model.User;

import java.util.List;
import java.util.Optional;

public interface CustomUserRepository {
    void deleteUserById(User user);
    List<User> findUserByPhoneAndAge(String phone, int age);
}
