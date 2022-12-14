package com.store.springbootbookstore.service;

import com.store.springbootbookstore.model.Role;
import com.store.springbootbookstore.model.User;
import com.store.springbootbookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreated_time(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void makeAdmin(String username) {
        userRepository.updateUserRole(username, Role.Admin);
    }
}
