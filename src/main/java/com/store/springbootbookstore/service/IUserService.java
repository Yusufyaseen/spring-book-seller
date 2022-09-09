package com.store.springbootbookstore.service;

import com.store.springbootbookstore.model.User;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUserName(String username);

    void makeAdmin(String username);
}
