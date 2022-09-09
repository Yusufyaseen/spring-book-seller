package com.store.springbootbookstore.service;

import com.store.springbootbookstore.Security.Jwt.IJwtProvider;
import com.store.springbootbookstore.Security.UserPrinciples;
import com.store.springbootbookstore.exceptions.ExceptionResponse;
import com.store.springbootbookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationService implements IAuthenticationService {

    @Autowired
    public AuthenticationManager authenticationManager;

    @Autowired
    public IJwtProvider jwtProvider;

    @Override
    public User signInAndReturnJwt(User signInRequest) {
        Authentication usernameAndPassword = new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(
                usernameAndPassword
        );
        // authenticationManager will call the loadUserByUsername in UserDetailsService from file MockAuthenticationManager.java  .
        UserPrinciples userPrinciples = (UserPrinciples) authentication.getPrincipal();
        String token = jwtProvider.generateToken(userPrinciples);
        User signInUser = userPrinciples.getUser();
        signInUser.setToken(token);
        return signInUser;


    }
}
