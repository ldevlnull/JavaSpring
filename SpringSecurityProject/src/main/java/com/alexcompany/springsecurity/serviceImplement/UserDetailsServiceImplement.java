package com.alexcompany.springsecurity.serviceImplement;

import com.alexcompany.springsecurity.model.User;
import com.alexcompany.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserDetailsServiceImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findOne(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with such username " + username));
        List<GrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.name())));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                roles
        );
    }
}
