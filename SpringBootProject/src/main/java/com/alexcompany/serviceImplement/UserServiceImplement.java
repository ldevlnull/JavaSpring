package com.alexcompany.serviceImplement;

import com.alexcompany.model.User;
import com.alexcompany.repository.UserRepository;
import com.alexcompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static org.springframework.data.jpa.domain.Specification.*;

/**
 * Created by User on 17.07.2019.
 */
@Service
public class UserServiceImplement implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    static Specification<User> hasPhone(String phone){
        return (user, cq, cb) -> cb.equal(user.get("phone"), phone);
    }
    static Specification<User> hasAge(int age){
        return (user, cq, cb) -> cb.equal(user.get("age"), age);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
