package com.alexcompany.springsecurity.serviceImplement;

import com.alexcompany.springsecurity.dto.UserDTO;
import com.alexcompany.springsecurity.model.Role;
import com.alexcompany.springsecurity.model.User;
import com.alexcompany.springsecurity.repository.UserRepository;
import com.alexcompany.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findOne(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean checkIfExists(String username, String email) {
        return userRepository.existsUserByUsernameOrEmail(username, email);
    }

    @Override
    public void delete(String username) {
        userRepository.delete(userRepository.findUserByUsername(username).orElse(new User()));
    }

    @Override
    public User registerNewUser(UserDTO u) {
        User user = new User();
        user.setEmail(u.getEmail());
        user.setUsername(u.getUsername());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setRoles(List.of(Role.ROLE_USER));
        userRepository.save(user);
        return user;
    }

}
